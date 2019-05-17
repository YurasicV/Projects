package app.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "TASKS")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "SUBJECT", length = 50)
    private String subject;

    @Column(name = "DESCRIPTION", length = 255)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
    @JoinColumn(name = "AUTHOR_ID")
    private User author;

    @Column(name = "DT_CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCreated;

    @OneToMany(mappedBy="task", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Resolution> resolutions;

    @Column(name = "TASK_STATUS_ID")
    @Enumerated(EnumType.ORDINAL)
    private TaskStatus taskStatus;

//    @Column(name = "TASK_STATE_ID")
//    @Enumerated(EnumType.ORDINAL)
    private TaskState taskState;

    @Column(name = "RESULT_ID")
    @Enumerated(EnumType.ORDINAL)
    private Result result;

    @OneToMany(mappedBy="task", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<TaskLog> taskLogs;

    public Task(User author, String subject, String description, TaskStatus taskStatus) {
        this();
        this.author = author;
        this.subject = subject;
        this.description = description;
        this.taskStatus = taskStatus;
    }

    public Task() {
        this.dtCreated = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(Date dtCreated) {
        this.dtCreated = dtCreated;
    }

    public Set<Resolution> getResolutions() {
        return resolutions;
    }

    public void setResolutions(Set<Resolution> resolutions) {
        this.resolutions = resolutions;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public TaskState getTaskState() {
        return taskState;
    }

    public void setTaskState(TaskState taskState) {
        this.taskState = taskState;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}