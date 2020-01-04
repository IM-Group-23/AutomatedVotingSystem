package im.vtngsystm.dto;

import java.time.LocalDateTime;

public class VoteDTO extends SuperDTO {

    private int voteId;
    private ElectionDTO election;
    private ContestantDTO contestant;
    private String voterId;
    private int vote;
    private LocalDateTime dateTime;

    public VoteDTO() {
    }

    public VoteDTO(int voteId, ElectionDTO election, ContestantDTO contestant, String voterId, int vote, LocalDateTime dateTime) {
        this.voteId = voteId;
        this.election = election;
        this.contestant = contestant;
        this.voterId = voterId;
        this.vote = vote;
        this.dateTime = dateTime;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public ElectionDTO getElection() {
        return election;
    }

    public void setElection(ElectionDTO election) {
        this.election = election;
    }

    public ContestantDTO getContestant() {
        return contestant;
    }

    public void setContestant(ContestantDTO contestant) {
        this.contestant = contestant;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }
}
