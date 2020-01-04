package im.vtngsystm.dto;

import java.util.ArrayList;
import java.util.List;

public class ElectoralDistrictDTO extends SuperDTO {

    private int id;
    private String name;
    private String province;
    private List<PollingDivisionDTO> pollingDivisionDTOS;

    public ElectoralDistrictDTO() {
    }

    public ElectoralDistrictDTO(int id, String name, String province, List<PollingDivisionDTO> pollingDivisionDTOS) {
        this.id = id;
        this.name = name;
        this.province = province;
        this.pollingDivisionDTOS = pollingDivisionDTOS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<PollingDivisionDTO> getPollingDivisionDTOS() {
        return pollingDivisionDTOS;
    }

    public void setPollingDivisionDTOS(ArrayList<PollingDivisionDTO> pollingDivisionDTOS) {
        this.pollingDivisionDTOS = pollingDivisionDTOS;
    }
}
