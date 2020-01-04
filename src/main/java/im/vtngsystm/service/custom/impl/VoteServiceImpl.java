package im.vtngsystm.service.custom.impl;

import im.vtngsystm.dto.ElectionContestantDTO;
import im.vtngsystm.dto.VoteDTO;
import im.vtngsystm.dto.VoterDTO;
import im.vtngsystm.entity.ElectionContestant;
import im.vtngsystm.entity.Vote;
import im.vtngsystm.repository.VoteRepository;
import im.vtngsystm.service.custom.VoteService;
import im.vtngsystm.service.util.EntityDtoConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class VoteServiceImpl implements VoteService {

    @Autowired
    EntityDtoConvertor entityDtoConvertor;
    @Autowired
    private VoteRepository voteRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(VoteDTO dto) {
        Vote vote = (Vote) entityDtoConvertor.convertToEntity(dto);
        voteRepository.save(vote);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void update(int id, VoteDTO dto) {
        if (dto.getVoteId() != id) {
            throw new RuntimeException("Vote ID mismatched");
        }
        if (voteRepository.existsById(id)) {
            Vote vote = (Vote) entityDtoConvertor.convertToEntity(dto);
            voteRepository.save(vote);
        } else {
            throw new RuntimeException("Vote doesn't exist");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(int id) {
        voteRepository.deleteById(id);
    }

    @Override
    public VoteDTO findByID(int id) {
        Vote vote = voteRepository.findById(id).get();
        return (VoteDTO) entityDtoConvertor.convertToDTO(vote);
    }

    @Override
    public int findVoteCountForElectionContestant(ElectionContestantDTO electionContestantDTO) {
        ElectionContestant electionContestant = (ElectionContestant) entityDtoConvertor.convertToEntity(electionContestantDTO);
        return voteRepository.findVotesByElectionContestantIs(electionContestant).size();
    }

    @Override
    public List<VoteDTO> findVotesByVoter(VoterDTO voterDTO) {
        List<Vote> votesByVoter = voteRepository.findVotesByVoter(voterDTO.getUsername());
        return entityDtoConvertor.convertToDtoList(votesByVoter);
    }

    @Override
    public long getCount() {
        return voteRepository.count();
    }
}
