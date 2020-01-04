package im.vtngsystm.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class UserEntity extends SuperEntity {

    @Id
    @Column(name = "USERNAME")
    protected String username;

    @Column(name = "PASSWORD", nullable = false)
    protected String password;

    @Column(name = "FULL_NAME", nullable = false)
    protected String name;

    @Column(name = "TITLE")
    protected String title;

    @Column(name = "EMAIL")
    protected String email;

    public UserEntity() {
    }

    public UserEntity(String username, String password, String name, String title, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.title = title;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
