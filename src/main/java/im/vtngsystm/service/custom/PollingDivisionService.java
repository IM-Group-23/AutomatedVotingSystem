package im.vtngsystm.service.custom;

import im.vtngsystm.dto.ContestantDTO;
import im.vtngsystm.dto.PollingDivisionDTO;
import im.vtngsystm.service.SuperService;

import java.util.List;

public interface PollingDivisionService extends SuperService<PollingDivisionDTO> {

    List<ContestantDTO> findContestantsByPollingDivisionAndParty(String details);
}
