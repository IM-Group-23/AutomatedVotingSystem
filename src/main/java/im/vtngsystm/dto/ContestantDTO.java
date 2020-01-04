package im.vtngsystm.dto;

import java.util.ArrayList;
import java.util.List;

public class ContestantDTO extends SuperDTO {

    private int contestId;
    private String name;
    private String province;
    private String district;
    private String pollDiv;
    private String party;
    private List<ElectionContestantDTO> electionDetails = new ArrayList<>();

    public ContestantDTO() {
    }

    public ContestantDTO(int contestId, String name, String province, String district, String pollDiv, String party) {
        this.contestId = contestId;
        this.name = name;
        this.province = province;
        this.district = district;
        this.pollDiv = pollDiv;
        this.party = party;
    }

    public ContestantDTO(int contestId, String name, String province, String district, String pollDiv, String party, List<ElectionContestantDTO> electionDetails) {
        this.contestId = contestId;
        this.name = name;
        this.province = province;
        this.district = district;
        this.pollDiv = pollDiv;
        this.party = party;
        this.electionDetails = electionDetails;
    }

    public ContestantDTO(String name, String province, String district, String pollDiv, String party) {
        this.name = name;
        this.province = province;
        this.district = district;
        this.pollDiv = pollDiv;
        this.party = party;
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

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPollDiv() {
        return pollDiv;
    }

    public void setPollDiv(String pollDiv) {
        this.pollDiv = pollDiv;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public List<ElectionContestantDTO> getElectionDetails() {
        return electionDetails;
    }

    public void setElectionDetails(List<ElectionContestantDTO> electionDetails) {
        this.electionDetails = electionDetails;
    }
}
