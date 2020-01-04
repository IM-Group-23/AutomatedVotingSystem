package im.vtngsystm.service.custom;

import im.vtngsystm.dto.ElectoralDistrictDTO;
import im.vtngsystm.dto.ProvinceDTO;
import im.vtngsystm.service.SuperService;

import java.util.List;

public interface ProvinceService extends SuperService<ProvinceDTO> {
    List<ElectoralDistrictDTO> findDistrictByProvince(String name);
}
