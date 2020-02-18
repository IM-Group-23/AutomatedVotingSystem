package im.vtngsystm.dto;

public class Voter_GRN_DTO {
    private VoterDTO voterDTO;
    private GramaNiladariDTO gramaNiladariDTO;

    public Voter_GRN_DTO() {
    }

    public Voter_GRN_DTO(VoterDTO voterDTO, GramaNiladariDTO gramaNiladariDTO) {
        this.voterDTO = voterDTO;
        this.gramaNiladariDTO = gramaNiladariDTO;
    }

    public VoterDTO getVoterDTO() {
        return voterDTO;
    }

    public void setVoterDTO(VoterDTO voterDTO) {
        this.voterDTO = voterDTO;
    }

    public GramaNiladariDTO getGramaNiladariDTO() {
        return gramaNiladariDTO;
    }

    public void setGramaNiladariDTO(GramaNiladariDTO gramaNiladariDTO) {
        this.gramaNiladariDTO = gramaNiladariDTO;
    }
}
