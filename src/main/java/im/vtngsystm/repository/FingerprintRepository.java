package im.vtngsystm.repository;

import im.vtngsystm.entity.ElectionCommissioner;
import im.vtngsystm.entity.Fingerprint;
import im.vtngsystm.entity.GramaNiladari;
import im.vtngsystm.entity.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FingerprintRepository extends JpaRepository<Fingerprint, String> {

    List<Fingerprint> findFingerprintsByElectionCommissioner(ElectionCommissioner electionCommissioner);

    List<Fingerprint> findFingerprintsByGramaNiladari(GramaNiladari gramaNiladari);

    List<Fingerprint> findFingerprintsByVoter(Voter voter);
}
