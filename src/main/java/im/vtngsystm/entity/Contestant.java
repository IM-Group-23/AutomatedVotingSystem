package im.vtngsystm.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CONTESTANT")
public class Contestant extends SuperEntity {

    @Id
    @Column(name = "CONTEST_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contestId;

    @Column(name = "CONTEST_NAME", nullable = false)
    private String name;

    @ManyToOne()
    @JoinColumn(name = "POLL_ID", nullable = false)
    private PollingDivision pollingDivision;

    @ManyToOne
    @JoinColumn(name = "PARTY_INIT", nullable = false)
    private Party party;

    @OneToMany(mappedBy = "primaryKey.contestant")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ElectionContestant> electionContestants;

    public Contestant() {
    }

    public Contestant(int contestId, String name, PollingDivision pollingDivision, Party party, List<ElectionContestant> electionContestants) {
        this.contestId = contestId;
        this.name = name;
        this.pollingDivision = pollingDivision;
        this.party = party;
        this.electionContestants = electionContestants;
    }

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PollingDivision getPollingDivision() {
        return pollingDivision;
    }

    public void setPollingDivision(PollingDivision pollingDivision) {
        this.pollingDivision = pollingDivision;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public List<ElectionContestant> getElectionContestant() {
        return electionContestants;
    }

    public void setElectionContestant(List<ElectionContestant> electionContestants) {
        this.electionContestants = electionContestants;
    }
}
