package objects;

import repository.entity.Entity;

public class Student implements Entity {
    private int id;
    private String name;
    private Group group;

    public Student(int id, String name, Group group) {
        this.id = id;
        this.name = name;
        this.group = group;
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public int getEntityId() {
        return getId();
    }
}
