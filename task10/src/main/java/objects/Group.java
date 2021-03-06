package objects;

import repository.entity.Entity;

public class Group implements Entity {
    private int id;
    private String name;

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[Group id=" + getId() + ", name=" + getName() + "]";
    }

    @Override
    public int getEntityId() {
        return getId();
    }
}
