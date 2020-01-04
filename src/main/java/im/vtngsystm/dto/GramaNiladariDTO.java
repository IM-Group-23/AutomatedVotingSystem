package im.vtngsystm.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("session")
public class GramaNiladariDTO extends UserDTO {

    private String mobile;
    private String province;
    private String district;
    private String pollDiv;
    private String gnProvision;
    private List<VoterDTO> voters;

    public GramaNiladariDTO() {
    }

    public GramaNiladariDTO(String username, String password, String name, String title, String email, String mobile, String province, String district, String pollDiv, String gnProvision, List<VoterDTO> voters) {
        super(username, password, name, title, email);
        this.mobile = mobile;
        this.province = province;
        this.district = district;
        this.pollDiv = pollDiv;
        this.gnProvision = gnProvision;
        this.voters = voters;
    }

    public GramaNiladariDTO(String username, String password, String name, String title, String email, String mobile, String province, String district, String pollDiv, String gnProvision) {
        super(username, password, name, title, email);
        this.mobile = mobile;
        this.province = province;
        this.district = district;
        this.pollDiv = pollDiv;
        this.gnProvision = gnProvision;
    }

    public GramaNiladariDTO(String username, String password, String name, String title, String email, String mobile, String gnProvision) {
        super(username, password, name, title, email);
        this.mobile = mobile;
        this.gnProvision = gnProvision;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getGnProvision() {
        return gnProvision;
    }

    public void setGnProvision(String gnProvision) {
        this.gnProvision = gnProvision;
    }

    public List<VoterDTO> getVoters() {
        return voters;
    }

    public void setVoters(List<VoterDTO> voters) {
        this.voters = voters;
    }
}
