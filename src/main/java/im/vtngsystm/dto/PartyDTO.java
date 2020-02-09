package im.vtngsystm.dto;

public class PartyDTO extends SuperDTO {

    private String partyInitials;
    private String partyName;

    public PartyDTO() {
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

}
