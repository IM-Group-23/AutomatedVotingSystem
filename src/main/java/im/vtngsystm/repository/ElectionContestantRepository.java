package im.vtngsystm.repository;

import im.vtngsystm.entity.ElectionContestant;
import im.vtngsystm.entity.ElectionContestantID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ElectionContestantRepository extends JpaRepository<ElectionContestant, ElectionContestantID> {

    @Query("SELECT e from ElectionContestant e where e.primaryKey.contestant.contestId=?#{0}")
    List<ElectionContestant> findElectionContestantsByContestant(int c);


    //    @Query("SELECT e from ElectionContestant e where e.primaryKey.contestant.contestId=?#{0} AND e.primaryKey.election.elecId=?#{1}")
    @Query(nativeQuery = true, value = "SELECT * FROM ElectionContestant WHERE CONTEST_ID=?1 AND ELECTION_ID=?2}")
    ElectionContestant findElectionContestantByContestantAndElection(int c, int e);

//    SELECT m FROM Machine m WHERE m.machinePK.machineId = 10

}
