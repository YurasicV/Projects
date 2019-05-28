package app.command.doaction;

import app.entity.Task;
import app.entity.TaskStatus;

public class DoStopActionCommand implements Command {
    private Task task;

    public DoStopActionCommand(Task task) {
        this.task = task;
    }

    public void execute() {
        task.setTaskStatus(TaskStatus.STOPPED);
    }
}
