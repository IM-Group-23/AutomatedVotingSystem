package im.vtngsystm.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ElectionContestantID extends SuperEntity implements Serializable {

    @ManyToOne
    private Election election;

    @ManyToOne
    private Contestant contestant;

    public ElectionContestantID(Election election, Contestant contestant) {
        this.election = election;
        this.contestant = contestant;
    }

    public ElectionContestantID() {
    }

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    public Contestant getContestant() {
        return contestant;
    }

    public void setContestant(Contestant contestant) {
        this.contestant = contestant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElectionContestantID)) return false;
        ElectionContestantID that = (ElectionContestantID) o;
        return Objects.equals(getElection(), that.getElection()) &&
                Objects.equals(getContestant(), that.getContestant());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getElection(), getContestant());
    }
}
