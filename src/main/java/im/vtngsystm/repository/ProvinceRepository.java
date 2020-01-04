package im.vtngsystm.repository;

import im.vtngsystm.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProvinceRepository extends JpaRepository<Province, Integer> {

    Province findProvinceByProvName(String name);

    @Query("SELECT p FROM Province p INNER JOIN ElectoralDistrict d ON p.provId=d.province.provId WHERE d.distName=?1")
//    @Query("SELECT p FROM ElectoralDistrict e JOIN e.province p WHERE e.distName=:districtName")
    Province findProvinceByDistrictName(String districtName);
}
