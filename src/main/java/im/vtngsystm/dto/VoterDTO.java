package im.vtngsystm.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Scope("session")
public class VoterDTO extends UserDTO {

    private LocalDate dob;
    private String mobile;
    private String address;
    private String province;
    private String district;
    private String pollingDivision;
    private GramaNiladariDTO gramaNiladari;
    private List<VoteDTO> votes;

    public VoterDTO(String username, String password, String name, String title, String email,
                    LocalDate dob, String mobile, String address, String province, String district, String pollingDivision,
                    GramaNiladariDTO gramaNiladari, List<VoteDTO> votes) {
        super(username, password, name, title, email);
        this.dob = dob;
        this.mobile = mobile;
        this.address = address;
        this.province = province;
        this.district = district;
        this.pollingDivision = pollingDivision;
        this.gramaNiladari = gramaNiladari;
        this.votes = votes;
    }

    public VoterDTO(String username, String password, String name, String title, String email, String mobile, String address) {
        super(username, password, name, title, email);
        this.mobile = mobile;
        this.address = address;
    }

    public VoterDTO() {
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getPollingDivision() {
        return pollingDivision;
    }

    public void setPollingDivision(String pollingDivision) {
        this.pollingDivision = pollingDivision;
    }

    public GramaNiladariDTO getGramaNiladari() {
        return gramaNiladari;
    }

    public void setGramaNiladari(GramaNiladariDTO gramaNiladari) {
        this.gramaNiladari = gramaNiladari;
    }

    public List<VoteDTO> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteDTO> votes) {
        this.votes = votes;
    }
}
