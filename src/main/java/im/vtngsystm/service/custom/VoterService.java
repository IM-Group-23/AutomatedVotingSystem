package im.vtngsystm.service.custom;

import im.vtngsystm.dto.GramaNiladariDTO;
import im.vtngsystm.dto.VoterDTO;
import im.vtngsystm.entity.Voter;
import im.vtngsystm.service.UserService;

import java.util.List;

public interface VoterService extends UserService<VoterDTO> {

    List<VoterDTO> findVoterByNameInPollingDivision(String name, int pollId);

    List<Voter> findVotersInPollingDivision(int pollId);

    List<VoterDTO> findVotersByGramaNiladari(GramaNiladariDTO gramaNiladariDTO);
}
