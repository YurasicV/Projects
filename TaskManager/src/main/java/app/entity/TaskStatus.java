package app.entity;

public enum TaskStatus {
    RUNNING(1, "Running"),
    STOPPED(2, "Stopped"),
    DONE(3, "Done");

    private Integer id;
    private String caption;

    TaskStatus(Integer id, String caption) {
        this.id = id;
        this.caption = caption;
    }

    public Integer getId() {
        return id;
    }

    public String getCaption() {
        return caption;
    }
}
