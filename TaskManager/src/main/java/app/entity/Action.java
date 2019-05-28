package app.entity;

public enum Action {
    SAVE(1, "Save", null),
    RUN(2, "Run", null),
    STOP(3, "Stop", null),
    AGREED(4, "Agreed", Result.YES),
    NOT_AGREED(5, "Not agreed", Result.NO),
    EXECUTED(6, "Executed", Result.YES),
    NOT_EXECUTED(7, "Not executed", Result.NO),
    ACQUAINTED(8, "Acquainted", Result.YES);

    private Integer id;
    private String caption;
    private Result result;

    Action(Integer id, String caption, Result result) {
        this.id = id;
        this.caption = caption;
        this.result = result;
    }

    public Integer getId() {
        return id;
    }

    public String getCaption() {
        return caption;
    }

    public Result getResult() {
        return result;
    }
}
