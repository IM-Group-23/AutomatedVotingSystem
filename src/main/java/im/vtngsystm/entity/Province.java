package im.vtngsystm.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PROVINCE")
public class Province extends SuperEntity {

    @Id
    @Column(name = "PROV_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int provId;

    @Column(name = "PROV_NAME", nullable = false)
    private String provName;

    @OneToMany(mappedBy = "province")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ElectoralDistrict> electoralDistricts = new ArrayList<>();

    public Province() {
    }

    public Province(int provId, String provName, List<ElectoralDistrict> electoralDistricts) {
        this.provId = provId;
        this.provName = provName;
        this.electoralDistricts = electoralDistricts;
    }

    public Province(String provName) {
        this.provName = provName;
    }

    public int getProvId() {
        return provId;
    }

    public void setProvId(int provId) {
        this.provId = provId;
    }

    public String getProvName() {
        return provName;
    }

    public void setProvName(String provName) {
        this.provName = provName;
    }

    public List<ElectoralDistrict> getElectoralDistricts() {
        return electoralDistricts;
    }

    public void setElectoralDistricts(List<ElectoralDistrict> electoralDistricts) {
        this.electoralDistricts = electoralDistricts;
    }
}
