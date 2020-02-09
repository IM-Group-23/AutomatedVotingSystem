package im.vtngsystm.dto;

import im.vtngsystm.entity.ElectionContestant;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ElectionDTO extends SuperDTO {

    private int id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String electionType;
    private List<ElectionContestantDTO> candidates;
    private ElectionContestant winner;

    public ElectionDTO() {
    }

    public ElectionDTO(int id, LocalDate date, LocalTime startTime, LocalTime endTime, String electionType) {
        this.id = id;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.electionType = electionType;
    }

    public ElectionDTO(LocalDate date, LocalTime startTime, LocalTime endTime, String electionType) {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
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
