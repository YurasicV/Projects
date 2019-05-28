package app.entity;

import app.converter.ActionConverter;
import app.converter.InstructionConverter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "RESOLUTIONS")
public class Resolution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "TASK_ID")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "QUEUE_NUMBER", length = 2)
    private Integer queueNumber;

    @Column(name = "INSTRUCTION_ID")
    @Convert(converter = InstructionConverter.class)
    private Instruction instruction;

    @Column(name = "ACTION_ID")
    @Convert(converter = ActionConverter.class)
    private Action action;

    public Resolution() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getQueueNumber() {
        return queueNumber;
    }

    public void setQueueNumber(Integer queueNumber) {
        this.queueNumber = queueNumber;
    }

    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resolution that = (Resolution) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}