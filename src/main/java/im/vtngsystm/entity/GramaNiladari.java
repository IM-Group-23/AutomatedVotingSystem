package im.vtngsystm.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "GRAMA_NILADARI")
public class GramaNiladari extends UserEntity {

    @Column(name = "GN_PROVISION")
    private String gnProvision;

    @Column(name = "CONTACT_NO")
    private String contact;

    @ManyToOne
    @JoinColumn(name = "POLL_ID", nullable = false)
    private PollingDivision pollingDivision;

    @OneToMany(mappedBy = "gramaNiladari")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Voter> voters = new ArrayList<>();

    public GramaNiladari(String username, String password, String name, String title, String email, String gnProvision,
                         String contact, PollingDivision pollingDivision, List<Voter> voters) {
        super(username, password, name, title, email);
        this.gnProvision = gnProvision;
        this.contact = contact;
        this.pollingDivision = pollingDivision;
        this.voters = voters;
    }

    public GramaNiladari() {
    }

    public GramaNiladari(String username, String password, String name, String title, String email, String gnProvision,
                         String contact, PollingDivision pollingDivision) {
        super(username, password, name, title, email);
        this.gnProvision = gnProvision;
        this.contact = contact;
        this.pollingDivision = pollingDivision;
    }

    public GramaNiladari(String username, String password, String name, String title, String email, String gnProvision, String contact) {
        super(username, password, name, title, email);
        this.gnProvision = gnProvision;
        this.contact = contact;
    }

    public String getGnProvision() {
        return gnProvision;
    }

    public void setGnProvision(String gnProvision) {
        this.gnProvision = gnProvision;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public PollingDivision getPollingDivision() {
        return pollingDivision;
    }

    public void setPollingDivision(PollingDivision pollingDivision) {
        this.pollingDivision = pollingDivision;
    }

    public List<Voter> getVoters() {
        return voters;
    }

    public void setVoters(List<Voter> voters) {
        this.voters = voters;
    }

}

