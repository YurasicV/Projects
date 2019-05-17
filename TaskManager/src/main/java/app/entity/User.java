package app.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "USERS", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "USERS_UK", columnNames = "USERNAME") })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "USERNAME", length = 50, nullable = false)
    private String userName;

    @Column(name = "PASSWORD", length = 128, nullable = false)
    private String password;

    @Column(name = "ENABLED", length = 1, nullable = false)
    private boolean enabled;

    @Column(name = "FULLNAME", length = 50, nullable = false)
    private String fullName;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "ROLES", joinColumns = @JoinColumn(name = "USER_ID"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @OneToMany(mappedBy="author", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Task> tasks;

    @OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Resolution> resolutions;

    @OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<TaskLog> taskLogs;

    public User(String userName, String password, String fullName) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}