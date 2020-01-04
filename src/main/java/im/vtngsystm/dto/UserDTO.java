package im.vtngsystm.dto;

public class UserDTO extends SuperDTO {

    protected String username;
    protected String password;
    protected String name;
    protected String title;
    protected String email;

    public UserDTO(String username, String password, String name, String title, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.title = title;
        this.email = email;
    }

    public UserDTO() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
