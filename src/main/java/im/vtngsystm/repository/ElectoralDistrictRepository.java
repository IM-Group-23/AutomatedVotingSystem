package im.vtngsystm.repository;

import im.vtngsystm.entity.ElectoralDistrict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ElectoralDistrictRepository extends JpaRepository<ElectoralDistrict, Integer> {

    ElectoralDistrict findElectoralDistrictByDistName(String name);

//    @Query("SELECT p FROM ElectoralDistrict e JOIN e.province p WHERE e.distName=:districtName")
//    Province findProvinceByDistrictName(String districtName);

    //    @Query(value = "SELECT * FROM ELECTORAL_DISTRICT WHERE DIST_ID=(SELECT DIST_ID FROM POLLING_DIVISION WHERE POLL_NAME=?#{0})",nativeQuery = true)
    @Query("SELECT e FROM ElectoralDistrict e INNER JOIN PollingDivision p ON e.distId=p.electoralDistrict.distId WHERE p.pollName=?1")
    ElectoralDistrict findElectoralDistrictByPollDivisionName(String pollName);
}
