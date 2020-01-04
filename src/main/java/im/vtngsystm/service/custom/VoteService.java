package im.vtngsystm.service.custom;

import im.vtngsystm.dto.ElectionContestantDTO;
import im.vtngsystm.dto.VoteDTO;
import im.vtngsystm.dto.VoterDTO;
import im.vtngsystm.service.SuperService;

import java.util.List;

public interface VoteService extends SuperService<VoteDTO> {

    @Override
    default VoteDTO findByName(String name) {
        System.out.println("this method is not valid for this service");
        throw new RuntimeException("Invalid method in service");
    }

    @Override
    default List<VoteDTO> findAll() {
        System.out.println("this method is not valid for this service");
        throw new RuntimeException("Invalid method in service");
    }

    int findVoteCountForElectionContestant(ElectionContestantDTO electionContestantDTO);

    List<VoteDTO> findVotesByVoter(VoterDTO voterDTO);
}
