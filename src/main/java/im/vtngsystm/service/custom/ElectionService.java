package im.vtngsystm.service.custom;

import im.vtngsystm.dto.ContestantDTO;
import im.vtngsystm.dto.ElectionDTO;
import im.vtngsystm.service.SuperService;

import java.util.List;

public interface ElectionService extends SuperService<ElectionDTO> {

    List<ContestantDTO> getCurrentElectionCandidates();

    ElectionDTO getRecentElection();
}
