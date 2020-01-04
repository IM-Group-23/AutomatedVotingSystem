package im.vtngsystm.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "POLLING_DIVISION")
public class PollingDivision extends SuperEntity {

    @Id
    @Column(name = "POLL_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pollId;

    @Column(name = "POLL_NAME", nullable = false)
    private String pollName;

    @ManyToOne
    @JoinColumn(name = "DIST_ID", nullable = false)
    private ElectoralDistrict electoralDistrict;

    @OneToMany(mappedBy = "pollingDivision")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Voter> voters = new ArrayList<>();

    @OneToMany(mappedBy = "pollingDivision")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Contestant> contestants = new ArrayList<>();

    @OneToMany(mappedBy = "pollingDivision")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<GramaNiladari> gramaNiladaris = new ArrayList<>();

    public PollingDivision() {
    }

    public PollingDivision(int pollId, String pollName, ElectoralDistrict electoralDistrict, List<Voter> voters, List<Contestant> contestants, List<GramaNiladari> gramaNiladaris) {
        this.pollId = pollId;
        this.pollName = pollName;
        this.electoralDistrict = electoralDistrict;
        this.voters = voters;
        this.contestants = contestants;
        this.gramaNiladaris = gramaNiladaris;
    }

    public PollingDivision(int pollId, String pollName, ElectoralDistrict electoralDistrict) {
        this.pollId = pollId;
        this.pollName = pollName;
        this.electoralDistrict = electoralDistrict;
    }

    public List<Voter> getVoters() {
        return voters;
    }

    public void setVoters(ArrayList<Voter> voters) {
        this.voters = voters;
    }

    public List<Contestant> getContestants() {
        return contestants;
    }

    public void setContestants(ArrayList<Contestant> contestants) {
        this.contestants = contestants;
    }

    public List<GramaNiladari> getGramaNiladaris() {
        return gramaNiladaris;
    }

    public void setGramaNiladaris(List<GramaNiladari> gramaNiladaris) {
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

    public ElectoralDistrict getElectoralDistrict() {
        return electoralDistrict;
    }

    public void setElectoralDistrict(ElectoralDistrict electoralDistrict) {
        this.electoralDistrict = electoralDistrict;
    }
}
