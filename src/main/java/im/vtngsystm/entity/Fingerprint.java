package im.vtngsystm.entity;


import javax.persistence.*;

@Entity
@Table(name = "FINGERPRINT")
public class Fingerprint extends SuperEntity {

    @Id
    @Column(name = "ENCODED_KEY")
    private String key;

    @ManyToOne
    @JoinColumn(name = "COMM_USERNAME")
    private ElectionCommissioner electionCommissioner;

    @ManyToOne
    @JoinColumn(name = "GRAMA_USERNAME")
    private GramaNiladari gramaNiladari;

    @ManyToOne
    @JoinColumn(name = "VOTER_USERNAME")
    private Voter voter;

    public Fingerprint() {
    }

    public Fingerprint(String key, ElectionCommissioner electionCommissioner) {
        this.key = key;
        this.electionCommissioner = electionCommissioner;
    }

    public Fingerprint(String key, GramaNiladari gramaNiladari) {
        this.key = key;
        this.gramaNiladari = gramaNiladari;
    }

    public Fingerprint(String key, Voter voter) {
        this.key = key;
        this.voter = voter;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ElectionCommissioner getElectionCommissioner() {
        return electionCommissioner;
    }

    public void setElectionCommissioner(ElectionCommissioner electionCommissioner) {
        this.electionCommissioner = electionCommissioner;
    }

    public GramaNiladari getGramaNiladari() {
        return gramaNiladari;
    }

    public void setGramaNiladari(GramaNiladari gramaNiladari) {
        this.gramaNiladari = gramaNiladari;
    }

    public Voter getVoter() {
        return voter;
    }

    public void setVoter(Voter voter) {
        this.voter = voter;
    }

    @Override
    public String toString() {
        return "Fingerprint{" +
                "key='" + key + '\'' +
                ", electionCommissioner=" + electionCommissioner +
                ", gramaNiladari=" + gramaNiladari +
                ", voter=" + voter +
                '}';
    }
}
