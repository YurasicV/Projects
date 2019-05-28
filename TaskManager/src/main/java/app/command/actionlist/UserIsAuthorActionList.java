package app.command.actionlist;

import app.entity.Action;
import app.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class UserIsAuthorActionList implements ActionList {
    private Task task;

    public UserIsAuthorActionList(Task task) {
        this.task = task;
    }

    public List<Action> getActionList() {
        List<Action> actions = new ArrayList<>();
        actions.add(Action.SAVE);
        if (isTaskResolutionsNotEmpty(task)) {
            actions.add(Action.RUN);
        }
        return actions;
    }

    private boolean isTaskResolutionsNotEmpty(Task task) {
        return (task.getId() != null) && (task.getResolutions().size() > 0);
    }
}
