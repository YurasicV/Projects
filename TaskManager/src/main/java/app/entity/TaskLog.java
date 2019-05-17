package app.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TASK_LOG")
public class TaskLog {

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

    @Column(name = "DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dt;

    @Column(name = "ACTION_ID")
    @Enumerated(EnumType.ORDINAL)
    private Action action;

    public TaskLog(Task task, User user, Action action) {
        this();
        this.task = task;
        this.user = user;
        this.action = action;
    }

    public TaskLog() {
        this.dt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
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
}