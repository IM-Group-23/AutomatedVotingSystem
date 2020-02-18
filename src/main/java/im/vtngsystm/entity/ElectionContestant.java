package im.vtngsystm.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ELECTION_CONTESTANT")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.election",
                joinColumns = @JoinColumn(name = "ELECTION_ID")),
        @AssociationOverride(name = "primaryKey.contestant",
                joinColumns = @JoinColumn(name = "CONTEST_ID"))
})
public class ElectionContestant extends SuperEntity {

    @EmbeddedId
    private ElectionContestantID primaryKey = new ElectionContestantID();

    @Column(name = "CANDIDATE_NO", nullable = false)
    private int candidateNo;

    @OneToMany(mappedBy = "electionContestant")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Vote> votes = new ArrayList<>();

    public ElectionContestant() {
    }

    public ElectionContestant(ElectionContestantID primaryKey, int candidateNo, List<Vote> votes) {
        this.primaryKey = primaryKey;
        this.candidateNo = candidateNo;
        this.votes = votes;
    }

    public ElectionContestant(ElectionContestantID primaryKey, int candidateNo) {
        this.primaryKey = primaryKey;
        this.candidateNo = candidateNo;
    }

    public ElectionContestant(ElectionContestantID primaryKey) {
        this.primaryKey = primaryKey;
    }

    public int getCandidateNo() {
        return candidateNo;
    }

    public void setCandidateNo(int candidateNo) {
        this.candidateNo = candidateNo;
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public ElectionContestantID getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(ElectionContestantID primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Election getElection() {
        return getPrimaryKey().getElection();
    }

    public void setElection(Election election) {
        getPrimaryKey().setElection(election);
    }

    public Contestant getContestant() {
        return getPrimaryKey().getContestant();
    }

    public void setContestant(Contestant contestant) {
        getPrimaryKey().setContestant(contestant);
    }
}
