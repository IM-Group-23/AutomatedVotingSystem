package im.vtngsystm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ELECTION_COMMISSIONER")
public class ElectionCommissioner extends UserEntity {

    @Column(name = "POST")
    String post;

    public ElectionCommissioner(String username, String password, String name, String title, String email, String post) {
        super(username, password, name, title, email);
        this.post = post;
    }

    public ElectionCommissioner() {
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

}
