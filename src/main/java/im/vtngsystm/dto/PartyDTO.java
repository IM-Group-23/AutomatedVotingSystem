package im.vtngsystm.dto;

import java.io.InputStream;
import java.util.List;

public class PartyDTO extends SuperDTO {

    private String partyInitials;
    private String partyName;
    private List<ContestantDTO> contestants;

    public PartyDTO() {
    }

    public PartyDTO(String partyInitials, String partyName, InputStream logo, List<ContestantDTO> contestants) {
        this.partyInitials = partyInitials;
        this.partyName = partyName;
        this.contestants = contestants;
    }

    public PartyDTO(String partyInitials, String partyName, List<ContestantDTO> contestants) {
        this.partyInitials = partyInitials;
        this.partyName = partyName;
        this.contestants = contestants;
    }

    public PartyDTO(String partyInitials, String partyName) {
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

    public List<ContestantDTO> getContestants() {
        return contestants;
    }

    public void setContestants(List<ContestantDTO> contestants) {
        this.contestants = contestants;
    }
}
