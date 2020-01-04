package im.vtngsystm.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PARTY")
public class Party extends SuperEntity {

    @Id
    @Column(name = "PARTY_INIT")
    private String partyInitials;

    @Column(name = "PARTY_NAME")
    private String partyName;

    @OneToMany(mappedBy = "party")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Contestant> contestants;

    public Party() {
    }

    public Party(String partyInitials, String partyName, List<Contestant> contestants) {
        this.partyInitials = partyInitials;
        this.partyName = partyName;
        this.contestants = contestants;
    }

    public Party(String partyInitials, String partyName) {
        this.partyInitials = partyInitials;
        this.partyName = partyName;
    }

    public String getPartyInitials() {
        return partyInitials;
    }

    public void setPartyInitials(String partyInitials) {
        this.partyInitials = partyInitials;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public List<Contestant> getContestants() {
        return contestants;
    }

    public void setContestants(List<Contestant> contestants) {
        this.contestants = contestants;
    }
}
