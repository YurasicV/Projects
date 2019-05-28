package app.command.actionlist;

import app.entity.Action;

import java.util.List;

public class ActionListInvoker {
    private RunningTaskActionList runningTaskActionList;
    private UserIsAuthorActionList userIsAuthorActionList;

    public ActionListInvoker(RunningTaskActionList runningTaskActionList,
                             UserIsAuthorActionList userIsAuthorActionList) {
        this.runningTaskActionList = runningTaskActionList;
        this.userIsAuthorActionList = userIsAuthorActionList;
    }

    public List<Action> getActionListWhenRunningTask() {
        return runningTaskActionList.getActionList();
    }

    public List<Action> getActionListWhenUserIsAuthor() {
        return userIsAuthorActionList.getActionList();
    }
}
