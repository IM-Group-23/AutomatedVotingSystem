package im.vtngsystm.dto;

import java.util.ArrayList;
import java.util.List;

public class ProvinceDTO extends SuperDTO {

    private int id;
    private String name;
    private List<ElectoralDistrictDTO> electoralDistrictDTOS = new ArrayList<>();

    public ProvinceDTO() {
    }

    public ProvinceDTO(int id, String name, List<ElectoralDistrictDTO> electoralDistrictDTOS) {
        this.id = id;
        this.name = name;
        this.electoralDistrictDTOS = electoralDistrictDTOS;
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

    public List<ElectoralDistrictDTO> getElectoralDistrictDTOS() {
        return electoralDistrictDTOS;
    }

    public void setElectoralDistrictDTOS(List<ElectoralDistrictDTO> electoralDistrictDTOS) {
        this.electoralDistrictDTOS = electoralDistrictDTOS;
    }
}
