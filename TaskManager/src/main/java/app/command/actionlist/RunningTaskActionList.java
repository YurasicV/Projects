package app.command.actionlist;

import app.entity.Action;
import app.entity.Resolution;
import app.entity.Task;
import app.entity.User;
import app.repository.ResolutionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class RunningTaskActionList implements ActionList {
    private ResolutionRepository resolutionRepository;
    private Task task;
    private User user;

    public RunningTaskActionList(Task task, User user, ResolutionRepository resolutionRepository) {
        this.task = task;
        this.user = user;
        this.resolutionRepository = resolutionRepository;
    }

    public List<Action> getActionList() {
        List<Action> actions = new ArrayList<>();
        Set<Resolution> resolutions = resolutionRepository.findAllByTask(task);
        Optional<Resolution> resolutionOptional = getNextResolutionByUser(resolutions, user);
        if (resolutionOptional.isPresent()) {
            Resolution resolution = resolutionOptional.get();
            if (isQueueNumberCurrent(resolutions, resolution.getQueueNumber())) {
                actions.addAll(resolution.getInstruction().getActions());
            }
        }
        if (user.equals(task.getAuthor())) {
            actions.add(Action.STOP);
        }
        return actions;
    }

    private Optional<Resolution> getNextResolutionByUser(Set<Resolution> resolutions, User user) {
        return resolutions.stream()
                .filter(r -> (user.equals(r.getUser())) && (r.getAction() == null)).findFirst();
    }

    private boolean isQueueNumberCurrent(Set<Resolution> resolutions, Integer queueNumber) {
        return resolutions.stream()
                .noneMatch(r -> (r.getQueueNumber() < queueNumber) && (r.getAction() == null));
    }
}
