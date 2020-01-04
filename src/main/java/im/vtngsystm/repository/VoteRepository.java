package im.vtngsystm.repository;

import im.vtngsystm.entity.ElectionContestant;
import im.vtngsystm.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Integer> {

    List<Vote> findVotesByElectionContestantIs(ElectionContestant electionContestant);

    //    @Query("SELECT v from Vote v INNER JOIN Voter vv ON v.voter.username=vv.username WHERE vv.username=?1")
    @Query(value = "select * from vote where voter_id=?1", nativeQuery = true)
    List<Vote> findVotesByVoter(String username);
}
