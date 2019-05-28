package app.command.doaction;

import app.entity.Resolution;
import app.entity.Task;
import app.entity.TaskStatus;
import app.repository.ResolutionRepository;

import java.util.Set;

public class DoRunActionCommand implements Command {
    private ResolutionRepository resolutionRepository;
    private Task task;

    public DoRunActionCommand(Task task,  ResolutionRepository resolutionRepository) {
        this.task = task;
        this.resolutionRepository = resolutionRepository;
    }

    public void execute() {
        task.setTaskStatus(TaskStatus.RUNNING);
        task.setResult(null);
        Set<Resolution> resolutions = resolutionRepository.findAllByTask(task);
        resolutions.forEach(r -> r.setAction(null));
    }
}
