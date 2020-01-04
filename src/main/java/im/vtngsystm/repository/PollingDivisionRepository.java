package im.vtngsystm.repository;

import im.vtngsystm.entity.PollingDivision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollingDivisionRepository extends JpaRepository<PollingDivision, Integer> {

    PollingDivision findPollingDivisionByPollNameIs(String pollName);

//    @Query("SELECT e FROM PollingDivision p JOIN p.electoralDistrict e WHERE p.name=:pollName")
//    @Query("select u.userName from User u inner join u.area ar where ar.idArea = :idArea")
//    ElectoralDistrict findElectoralDistrictByPollDivisionName(String pollName);

//    SELECT di FROM Device di JOIN di.user u WHERE u.id=:userId and di.deviceName=:deviceName
}
