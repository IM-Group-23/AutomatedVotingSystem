package im.vtngsystm.dto;


import java.util.List;

public class PollingDivisionDTO extends SuperDTO {

    private int pollId;
    private String pollName;
    private String province;
    private String electoralDistrict;
    private List<VoterDTO> voters;
    private List<ContestantDTO> contestants;
    private List<GramaNiladariDTO> gramaNiladaris;

    public PollingDivisionDTO() {
    }

    public PollingDivisionDTO(int pollId, String pollName, String province, String electoralDistrict, List<VoterDTO> voters, List<ContestantDTO> contestants, List<GramaNiladariDTO> gramaNiladaris) {
        this.pollId = pollId;
        this.pollName = pollName;
        this.province = province;
        this.electoralDistrict = electoralDistrict;
        this.voters = voters;
        this.contestants = contestants;
        this.gramaNiladaris = gramaNiladaris;
    }

    public int getPollId() {
        return pollId;
    }

    public void setPollId(int pollId) {
        this.pollId = pollId;
    }

    public String getPollName() {
        return pollName;
    }

    public void setPollName(String pollName) {
        this.pollName = pollName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getElectoralDistrict() {
        return electoralDistrict;
    }

    public void setElectoralDistrict(String electoralDistrict) {
        this.electoralDistrict = electoralDistrict;
    }

    public List<VoterDTO> getVoters() {
        return voters;
    }

    public void setVoters(List<VoterDTO> voters) {
        this.voters = voters;
    }

    public List<ContestantDTO> getContestants() {
        return contestants;
    }

    public void setContestants(List<ContestantDTO> contestants) {
        this.contestants = contestants;
    }

    public List<GramaNiladariDTO> getGramaNiladaris() {
        return gramaNiladaris;
    }

    public void setGramaNiladaris(List<GramaNiladariDTO> gramaNiladaris) {
        this.gramaNiladaris = gramaNiladaris;
    }
}
