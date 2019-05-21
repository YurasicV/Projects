package app.service;

import app.entity.*;
import app.repository.ResolutionRepository;
import app.repository.TaskLogRepository;
import app.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ActionService {
    private TaskRepository taskRepository;
    private TaskLogRepository taskLogRepository;
    private ResolutionRepository resolutionRepository;

    public ActionService(TaskRepository taskRepository, TaskLogRepository taskLogRepository,
                         ResolutionRepository resolutionRepository) {
        this.taskRepository = taskRepository;
        this.taskLogRepository = taskLogRepository;
        this.resolutionRepository = resolutionRepository;
    }

    public List<Action> getActionList(Task task, User user) {
        List<Action> actions = new ArrayList<>();
        TaskStatus status = task.getTaskStatus();
        User author = task.getAuthor();
        if (status == TaskStatus.RUNNING) {
            Set<Resolution> resolutions = resolutionRepository.findAllByTask(task);
            Optional<Resolution> resolutionOptional = resolutions.stream()
                    .filter(r -> (user.equals(r.getUser())) && (r.getAction() == null)).findFirst();
            if (resolutionOptional.isPresent()) {
                Resolution resolution = resolutionOptional.get();
                Integer queueNumber = resolution.getQueueNumber();
                if (resolutions.stream()
                        .noneMatch(r -> (r.getQueueNumber() < queueNumber) && (r.getAction() == null))) {
                    actions.addAll(resolution.getInstruction().getActions());
                }
            }
            if (user.equals(author)) {
                actions.add(Action.STOP);
            }
        } else {
            if (user.equals(author)) {
                actions.add(Action.SAVE);
                if ((task.getId() != null) && (task.getResolutions().size() > 0)) {
                    actions.add(Action.RUN);
                }
            }
        }
        actions.sort(Action::compareTo);
        return actions;
    }

    public void doAction(Task task, User user, Action action) {
        if (action == Action.RUN) {
            task.setTaskStatus(TaskStatus.RUNNING);
            task.setResult(null);
            Set<Resolution> resolutions = resolutionRepository.findAllByTask(task);
            resolutions.forEach(r -> r.setAction(null));
        } else if (action == Action.STOP) {
            task.setTaskStatus(TaskStatus.STOPPED);
        } else if (action != Action.SAVE) {
            Set<Resolution> resolutions = resolutionRepository.findAllByTask(task);
            Optional<Resolution> resolutionOptional = resolutions.stream()
                    .filter(r -> (user.equals(r.getUser())) && (r.getAction() == null)).findFirst();
            if (resolutionOptional.isPresent()) {
                Resolution resolution = resolutionOptional.get();
                resolution.setAction(action);
            }
            if (resolutions.stream()
                    .anyMatch(r -> (r.getAction() != null) && (r.getAction().getResult() == Result.NO))) {
                task.setResult(Result.NO);
                task.setTaskStatus(TaskStatus.DONE);
            } else if (resolutions.stream().noneMatch(r -> r.getAction() == null)) {
                task.setResult(Result.YES);
                task.setTaskStatus(TaskStatus.DONE);
            }
        }
        taskRepository.save(task);
        taskLogRepository.save(new TaskLog(task, user, action));
    }
}
