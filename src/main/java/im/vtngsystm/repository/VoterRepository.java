package im.vtngsystm.repository;

import im.vtngsystm.entity.GramaNiladari;
import im.vtngsystm.entity.PollingDivision;
import im.vtngsystm.entity.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoterRepository extends JpaRepository<Voter, String> {

    List<Voter> findVotersByGramaNiladari(GramaNiladari gramaNiladari);

    Voter findVoterByName(String name);

    List<Voter> findVotersByNameIsLikeAndPollingDivision(String name, PollingDivision pollingDivision);

    List<Voter> findVotersByPollingDivision(PollingDivision pollingDivision);
}
