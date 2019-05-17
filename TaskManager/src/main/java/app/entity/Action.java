package app.entity;

public enum Action {
    AGREED(Result.YES),
    NOT_AGREED(Result.NO),
    EXECUTED(Result.YES),
    NOT_EXECUTED(Result.NO),
    ACQUAINTED(Result.YES);

    private Result result;

    Action(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }
}
