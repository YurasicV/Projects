package app.service;

import app.entity.*;
import app.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private TaskRepository taskRepository;
    private ActionService actionService;

    public TaskService(TaskRepository taskRepository, ActionService actionService) {
        this.taskRepository = taskRepository;
        this.actionService = actionService;
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public Page<Task> findAllByUser(User user, Pageable pageable) {
        Page<Task> tasks =taskRepository.findAllByResolutionUser(user, pageable);
        tasks.forEach(t -> {
            t.setDirection(user.equals(t.getAuthor()) ? Direction.OUT : Direction.IN);
            t.setEditable(IsTaskEditable(t, user));
            t.setCurrent(IsTaskCurrent(t, user));
        });
        return tasks;
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    public Boolean IsTaskEditable(Task task, User user) {
        return ((task.getTaskStatus() != TaskStatus.RUNNING) &&
                (task.getAuthor().equals(user)));
    }

    public Boolean IsTaskCurrent(Task task, User user) {
        List<Action> actions = actionService.getActionList(task, user);
        return actions.stream().anyMatch(a -> (a.getResult() != null));
    }
}
