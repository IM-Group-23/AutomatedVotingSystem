package im.vtngsystm.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "VOTER")
public class Voter extends UserEntity {

    //the nic is used as the username to the system
    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CONTACT_NO")
    private String contactNo;

    @Column(name = "BIRTHDAY")
    private LocalDate birthdate;

    @ManyToOne
    @JoinColumn(name = "POLL_ID")
    private PollingDivision pollingDivision;

    @ManyToOne
    @JoinColumn(name = "GN_USERNAME")
    private GramaNiladari gramaNiladari;

    @OneToMany(mappedBy = "voter")
    private List<Vote> votes = new ArrayList<>();

    public Voter() {
    }

    public Voter(String username, String password, String name, String title, String email, String address,
                 String contactNo, LocalDate birthdate, PollingDivision pollingDivision,
                 GramaNiladari gramaNiladari, List<Vote> votes) {
        super(username, password, name, title, email);
        this.address = address;
        this.contactNo = contactNo;
        this.birthdate = birthdate;
        this.pollingDivision = pollingDivision;
        this.gramaNiladari = gramaNiladari;
        this.votes = votes;
    }

    public Voter(String username, String password, String name, String title, String email, String address, String contactNo,
                 PollingDivision pollingDivision, GramaNiladari gramaNiladari) {
        super(username, password, name, title, email);
        this.address = address;
        this.contactNo = contactNo;
        this.pollingDivision = pollingDivision;
        this.gramaNiladari = gramaNiladari;
    }

    public Voter(String username, String password, String name, String title, String email, String address, String contactNo) {
        super(username, password, name, title, email);
        this.address = address;
        this.contactNo = contactNo;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public GramaNiladari getGramaNiladari() {
        return gramaNiladari;
    }

    public void setGramaNiladari(GramaNiladari gramaNiladari) {
        this.gramaNiladari = gramaNiladari;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public PollingDivision getPollingDivision() {
        return pollingDivision;
    }

    public void setPollingDivision(PollingDivision pollingDivision) {
        this.pollingDivision = pollingDivision;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

}
