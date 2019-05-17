package app.entity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Instruction {
    AGREE(new Action[]{Action.AGREED, Action.NOT_AGREED}),
    EXECUTE(new Action[]{Action.EXECUTED, Action.NOT_EXECUTED}),
    ACQUAINT(new Action[] {Action.ACQUAINTED});

    private Set<Action> actions;

    Instruction(Action[] actionsArray) {
        this.actions = new HashSet<Action>(Arrays.asList(actionsArray));
    }

    public Set<Action> getActions() {
        return actions;
    }
}
