package app.command.doaction;

import app.entity.*;
import app.repository.ResolutionRepository;

import java.util.Optional;
import java.util.Set;

public class DoResultActionCommand implements Command {
    private ResolutionRepository resolutionRepository;
    private Task task;
    private User user;
    private Action action;

    public DoResultActionCommand(Task task, User user, Action action, ResolutionRepository resolutionRepository) {
        this.task = task;
        this.user = user;
        this.action = action;
        this.resolutionRepository = resolutionRepository;
    }

    public void execute() {
        Set<Resolution> resolutions = resolutionRepository.findAllByTask(task);
        Optional<Resolution> resolutionOptional = getNextResolutionByUser(resolutions, user);
        if (resolutionOptional.isPresent()) {
            Resolution resolution = resolutionOptional.get();
            resolution.setAction(action);
        }
        if (isAnyResolutionFailed(resolutions)) {
            task.setResult(Result.NO);
            task.setTaskStatus(TaskStatus.DONE);
        } else if (isAllResolutionsDone(resolutions)) {
            task.setResult(Result.YES);
            task.setTaskStatus(TaskStatus.DONE);
        }
    }

    private Optional<Resolution> getNextResolutionByUser(Set<Resolution> resolutions, User user) {
        return resolutions.stream()
                .filter(r -> (user.equals(r.getUser())) && (r.getAction() == null)).findFirst();
    }

    private boolean isAnyResolutionFailed(Set<Resolution> resolutions) {
        return resolutions.stream()
                .anyMatch(r -> (r.getAction() != null) && (r.getAction().getResult() == Result.NO));
    }

    private boolean isAllResolutionsDone(Set<Resolution> resolutions) {
        return resolutions.stream().noneMatch(r -> r.getAction() == null);
    }
}
