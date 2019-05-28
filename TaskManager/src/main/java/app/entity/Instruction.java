package app.entity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Instruction {
    TO_AGREE(1, "To agree", new Action[]{Action.AGREED, Action.NOT_AGREED}),
    TO_EXECUTE(2, "To execute", new Action[]{Action.EXECUTED, Action.NOT_EXECUTED}),
    TO_ACQUAINT(3, "To acquaint", new Action[] {Action.ACQUAINTED});

    private Integer id;
    private String caption;
    private Set<Action> actions;

    Instruction(Integer id, String caption, Action[] actionsArray) {
        this.id = id;
        this.caption = caption;
        this.actions = new HashSet<Action>(Arrays.asList(actionsArray));
    }

    public Integer getId() {
        return id;
    }

    public String getCaption() {
        return caption;
    }

    public Set<Action> getActions() {
        return actions;
    }
}
