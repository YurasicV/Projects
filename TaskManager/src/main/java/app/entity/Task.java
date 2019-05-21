package app.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
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

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID")
    private User author;

    @Column(name = "DT_CREATED")
    @CreationTimestamp
    private LocalDateTime dtCreated;

    @OneToMany(mappedBy="task", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderBy("queueNumber ASC")
    private Set<Resolution> resolutions;

    @Column(name = "TASK_STATUS_ID")
    @Enumerated(EnumType.ORDINAL)
    private TaskStatus taskStatus;

    @Column(name = "RESULT_ID")
    @Enumerated(EnumType.ORDINAL)
    private Result result;

    @OneToMany(mappedBy="task", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<TaskLog> taskLogs;

    @Transient
    private Direction direction;

    @Transient
    private Boolean editable;

    @Transient
    private Boolean current;

    public Task() {
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

    public LocalDateTime getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(LocalDateTime dtCreated) {
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

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Boolean isEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public Boolean getCurrent() {
        return current;
    }

    public void setCurrent(Boolean current) {
        this.current = current;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id.equals(task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}