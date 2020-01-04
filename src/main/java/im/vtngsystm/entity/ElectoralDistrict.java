package im.vtngsystm.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ELECTORAL_DISTRICT")
public class ElectoralDistrict extends SuperEntity {
// among the 25 districts in Sri Lanka, only 22 are recognized as electoral  districts

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DIST_ID")
    private int distId;

    @Column(name = "DIST_NAME", nullable = false)
    private String distName;

    @ManyToOne
    @JoinColumn(name = "PROV_ID", nullable = false)
    private Province province;

    @OneToMany(mappedBy = "electoralDistrict")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PollingDivision> pollingDivisions = new ArrayList<>();

    public ElectoralDistrict() {
    }

    public ElectoralDistrict(String distName, Province province, List<PollingDivision> pollingDivisions) {
        this.distName = distName;
        this.province = province;
        this.pollingDivisions = pollingDivisions;
    }

    public ElectoralDistrict(int distId, String distName, Province province, List<PollingDivision> pollingDivisions) {
        this.distId = distId;
        this.distName = distName;
        this.province = province;
        this.pollingDivisions = pollingDivisions;
    }

    public int getDistId() {
        return distId;
    }

    public void setDistId(int distId) {
        this.distId = distId;
    }

    public String getDistName() {
        return distName;
    }

    public void setDistName(String distName) {
        this.distName = distName;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public List<PollingDivision> getPollingDivisions() {
        return pollingDivisions;
    }

    public void setPollingDivisions(ArrayList<PollingDivision> pollingDivisions) {
        this.pollingDivisions = pollingDivisions;
    }

}
