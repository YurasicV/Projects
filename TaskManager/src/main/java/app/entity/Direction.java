package app.entity;

public enum Direction {
    IN(1, "Incoming"),
    OUT(2, "Outgoing");

    private Integer id;
    private String caption;

    Direction(Integer id, String caption) {
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
