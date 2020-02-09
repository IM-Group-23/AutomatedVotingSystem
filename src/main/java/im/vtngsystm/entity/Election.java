package im.vtngsystm.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "ELECTION")
public class Election extends SuperEntity {

    @Id
    @Column(name = "ELEC_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int elecId;

    @Column(name = "DATE", nullable = false)
    private LocalDate date; //not sure -> checking

    @Column(name = "START_TIME", nullable = false)
    private LocalTime startTime;

    @Column(name = "END_TIME", nullable = false)
    private LocalTime endTime;

    @Column(name = "ELECTION_TYPE", nullable = false)
    private String type;

    @OneToMany(mappedBy = "primaryKey.election")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ElectionContestant> electionContestants;

    public Election() {
    }

    public Election(int elecId, LocalDate date, LocalTime startTime, LocalTime endTime, String type, List<ElectionContestant> electionContestants) {
        this.elecId = elecId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
        this.electionContestants = electionContestants;
    }

    public Election(int elecId, LocalDate date, LocalTime startTime, LocalTime endTime, String type) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
        this.elecId = elecId;
    }

    public int getElecId() {
        return elecId;
    }

    public void setElecId(int elecId) {
        this.elecId = elecId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public List<ElectionContestant> getElectionContestant() {
        return electionContestants;
    }

    public void setElectionContestant(List<ElectionContestant> electionContestants) {
        this.electionContestants = electionContestants;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
