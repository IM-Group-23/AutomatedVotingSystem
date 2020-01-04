package im.vtngsystm.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "VOTE")
public class Vote extends SuperEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VOTE_ID")
    private int voteID;

    @Column(name = "VOTE", nullable = false)
    private int vote;

    @Column(name = "DATE_TIME", nullable = false)
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "VOTER_ID", nullable = false)
    private Voter voter;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "ELECTION_ID", referencedColumnName = "ELECTION_ID"),
            @JoinColumn(name = "CONTEST_ID", referencedColumnName = "CONTEST_ID")
    })
    private ElectionContestant electionContestant;

    public Vote() {
    }

    public Vote(int vote, LocalDateTime dateTime, Voter voter, ElectionContestant electionContestant) {
        this.vote = vote;
        this.dateTime = dateTime;
        this.voter = voter;
        this.electionContestant = electionContestant;
    }


//    public Vote(Vote_ID primaryKey, int vote, LocalDateTime dateTime) {
//        this.primaryKey = primaryKey;
//        this.vote = vote;
//        this.dateTime = dateTime;
//    }
//
//    public Vote_ID getPrimaryKey() {
//        return primaryKey;
//    }
//
//    public void setPrimaryKey(Vote_ID primaryKey) {
//        this.primaryKey = primaryKey;
//    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

//    public Voter getVoter() {
//        return getPrimaryKey().getVoter();
//    }
//
//    public void setVoter(Voter voter) {
//        getPrimaryKey().setVoter(voter);
//    }
//
//    public ElectionContestant getElectionContestant() {
//        return getPrimaryKey().getElectionContestant();
//    }
//
//    public void setElectionContestant(ElectionContestant electionContestant) {
//        getPrimaryKey().setElectionContestant(electionContestant);
//    }


    public int getVoteID() {
        return voteID;
    }

    public void setVoteID(int voteID) {
        this.voteID = voteID;
    }

    public Voter getVoter() {
        return voter;
    }

    public void setVoter(Voter voter) {
        this.voter = voter;
    }

    public ElectionContestant getElectionContestant() {
        return electionContestant;
    }

    public void setElectionContestant(ElectionContestant electionContestant) {
        this.electionContestant = electionContestant;
    }
}
