package im.vtngsystm.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class ElectionCommissionerDTO extends UserDTO {

    private String post;

    public ElectionCommissionerDTO(String username, String password, String name, String title, String email, String post) {
        super(username, password, name, title, email);
        this.post = post;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

}
