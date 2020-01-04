package im.vtngsystm.service.custom;

import im.vtngsystm.dto.ElectoralDistrictDTO;
import im.vtngsystm.dto.PollingDivisionDTO;
import im.vtngsystm.service.SuperService;

import java.util.List;

public interface ElectoralDistrictService extends SuperService<ElectoralDistrictDTO> {

    List<PollingDivisionDTO> findPollingDivisionsByDistrict(String name);
}
