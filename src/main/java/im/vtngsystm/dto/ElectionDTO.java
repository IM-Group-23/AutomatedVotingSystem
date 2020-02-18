package im.vtngsystm.dto;

import im.vtngsystm.entity.ElectionContestant;

import java.util.List;

public class ElectionDTO extends SuperDTO {

    private int id;
    private String date;
    private String startTime;
    private String endTime;
    private String electionType;
    private List<ElectionContestantDTO> candidates;
    private ElectionContestant winner;

    public ElectionDTO() {
    }

    public ElectionDTO(int id, String date, String startTime, String endTime, String electionType) {
        this.id = id;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.electionType = electionType;
    }

    public ElectionDTO(String date, String startTime, String endTime, String electionType) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.electionType = electionType;
    }

    public String getElectionType() {
        return electionType;
    }

    public void setElectionType(String electionType) {
        this.electionType = electionType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<ElectionContestantDTO> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<ElectionContestantDTO> candidates) {
        this.candidates = candidates;
    }

    public ElectionContestant getWinner() {
        return winner;
    }

    public void setWinner(ElectionContestant winner) {
        this.winner = winner;
    }
}
