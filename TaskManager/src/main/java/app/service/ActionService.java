package app.service;

import app.command.actionlist.ActionListInvoker;
import app.command.actionlist.RunningTaskActionList;
import app.command.actionlist.UserIsAuthorActionList;
import app.command.doaction.DoActionInvoker;
import app.command.doaction.DoResultActionCommand;
import app.command.doaction.DoRunActionCommand;
import app.command.doaction.DoStopActionCommand;
import app.entity.*;
import app.repository.ResolutionRepository;
import app.repository.TaskLogRepository;
import app.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        ActionListInvoker actionListInvoker = new ActionListInvoker(
                new RunningTaskActionList(task, user, resolutionRepository),
                new UserIsAuthorActionList(task));

        List<Action> actions = new ArrayList<>();
        TaskStatus status = task.getTaskStatus();
        User author = task.getAuthor();
        if (status == TaskStatus.RUNNING) {
            actions.addAll(actionListInvoker.getActionListWhenRunningTask());
        } else if (user.equals(author)) {
            actions.addAll(actionListInvoker.getActionListWhenUserIsAuthor());
        }
        actions.sort(Action::compareTo);
        return actions;
    }

    public void doAction(Task task, User user, Action action) {
        DoActionInvoker doActionInvoker = new DoActionInvoker(
                new DoRunActionCommand(task, resolutionRepository),
                new DoStopActionCommand(task),
                new DoResultActionCommand(task, user, action, resolutionRepository));
        if (action == Action.RUN) {
            doActionInvoker.invokeRunAction();
        } else if (action == Action.STOP) {
            doActionInvoker.invokeStopAction();
        } else if (action.getResult() != null) {
            doActionInvoker.invokeResultAction();
        }
        taskRepository.save(task);
        taskLogRepository.save(new TaskLog(task, user, action));
    }
}
