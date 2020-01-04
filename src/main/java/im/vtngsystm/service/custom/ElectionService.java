package im.vtngsystm.service.custom;

import im.vtngsystm.dto.ElectionDTO;
import im.vtngsystm.service.SuperService;

public interface ElectionService extends SuperService<ElectionDTO> {

    ElectionDTO getCurrentElection();
}
