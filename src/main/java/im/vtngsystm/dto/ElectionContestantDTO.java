package im.vtngsystm.dto;

public class ElectionContestantDTO extends SuperDTO {

    int contestID;
    String contestName;
    int elecID;
    int candidateNO;

    public ElectionContestantDTO() {
    }

    public ElectionContestantDTO(int contestID, int elecID, int candidateNO) {
        this.contestID = contestID;
        this.elecID = elecID;
        this.candidateNO = candidateNO;
    }

    public ElectionContestantDTO(String contestName, int candidateNO) {
        this.contestName = contestName;
        this.candidateNO = candidateNO;
    }

    public String getContestName() {
        return contestName;
    }

    public void setContestName(String contestName) {
        this.contestName = contestName;
    }

    public int getContestID() {
        return contestID;
    }

    public void setContestID(int contestID) {
        this.contestID = contestID;
    }

    public int getElecID() {
        return elecID;
    }

    public void setElecID(int elecID) {
        this.elecID = elecID;
    }

    public int getCandidateNO() {
        return candidateNO;
    }

    public void setCandidateNO(int candidateNO) {
        this.candidateNO = candidateNO;
    }

}
