package app.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "RESOLUTIONS")
public class Resolution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
    @JoinColumn(name = "TASK_ID")
    private Task task;

    @ManyToOne(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "QUEUE_NUMBER", length = 2)
    private Integer queueNumber;

    @Column(name = "INSTRUCTION_ID")
    @Enumerated(EnumType.ORDINAL)
    private Instruction instruction;

    @Column(name = "RESULT_ID")
    @Enumerated(EnumType.ORDINAL)
    private Result result;

    public Resolution(Task task, User user, Integer queueNumber, Instruction instruction) {
        this.task = task;
        this.user = user;
        this.queueNumber = queueNumber;
        this.instruction = instruction;
    }

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

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}