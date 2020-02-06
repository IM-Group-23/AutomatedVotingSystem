package im.vtngsystm.repository;

import im.vtngsystm.entity.GramaNiladari;
import im.vtngsystm.entity.PollingDivision;
import im.vtngsystm.entity.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoterRepository extends JpaRepository<Voter, String> {

    List<Voter> findVotersByGramaNiladari(GramaNiladari gramaNiladari);

    List<Voter> findVotersByNameIsLikeAndPollingDivision(String name, PollingDivision pollingDivision);

    List<Voter> findVotersByPollingDivision(PollingDivision pollingDivision);

    Voter findVoterByUsername(String nic);

//    @Query(value = "update VOTER set PASSWORD=?1 where USERNAME=?2", nativeQuery = true)
//    void updateVoterPassword(String otp,String nic);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Voter v SET v.password = :password WHERE v.username = :nic")
    int updateVoterPassword(@Param("nic") String nic, @Param("password") String otp);
}
