package app.entity;

public enum Result {
    YES(1, "Success"),
    NO(2, "Failure");

    private Integer id;
    private String caption;

    Result(Integer id, String caption) {
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
