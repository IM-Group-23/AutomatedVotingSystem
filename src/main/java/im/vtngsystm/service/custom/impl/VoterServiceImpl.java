package im.vtngsystm.service.custom.impl;

import im.vtngsystm.dto.GramaNiladariDTO;
import im.vtngsystm.dto.VoterDTO;
import im.vtngsystm.entity.GramaNiladari;
import im.vtngsystm.entity.PollingDivision;
import im.vtngsystm.entity.Voter;
import im.vtngsystm.repository.PollingDivisionRepository;
import im.vtngsystm.repository.VoterRepository;
import im.vtngsystm.service.custom.VoterService;
import im.vtngsystm.service.util.EntityDtoConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class VoterServiceImpl implements VoterService {

    @Autowired
    EntityDtoConvertor entityDtoConvertor;
    @Autowired
    private VoterRepository voterRepository;
    @Autowired
    private PollingDivisionRepository pollingDivisionRepository;

    @Override
    public void save(String id, VoterDTO dto) {
        if (dto.getUsername().equals(id)) {
            throw new RuntimeException("Voter's ID mismatched");
        }
        Voter entity = (Voter) entityDtoConvertor.convertToEntity(dto);
        voterRepository.save(entity);
    }

    @Override
    public void update(String id, VoterDTO dto) {
        if (dto.getUsername().equals(id)) {
            throw new RuntimeException("Voter's ID mismatched");
        }
        if (voterRepository.existsById(dto.getUsername())) {
            Voter entity = (Voter) entityDtoConvertor.convertToEntity(dto);
            voterRepository.save(entity);
        } else {
            throw new RuntimeException("Such Voter doesn't exist");
        }
    }

    @Override
    public void delete(String id) {
        voterRepository.deleteById(id);
    }

    @Override
    public VoterDTO findByID(String id) {
        Voter voter = voterRepository.findById(id).get();
        return (VoterDTO) entityDtoConvertor.convertToDTO(voter);
    }

    @Override
    public VoterDTO findByName(String name) {
        Voter voter = voterRepository.findById(name).get();
        return (VoterDTO) entityDtoConvertor.convertToDTO(voter);
    }

    @Override
    public List<VoterDTO> findAll() {
        List<Voter> all = voterRepository.findAll();
        return entityDtoConvertor.convertToDtoList(all);
    }


    @Override
    public List<VoterDTO> findVoterByNameInPollingDivision(String name, int pollId) {
        PollingDivision pollingDivision = pollingDivisionRepository.findById(pollId).get();
        List<Voter> voters = voterRepository.findVotersByNameIsLikeAndPollingDivision(name, pollingDivision);
        return entityDtoConvertor.convertToDtoList(voters);
    }

    @Override
    public List<Voter> findVotersInPollingDivision(int pollId) {
        PollingDivision pollingDivision = pollingDivisionRepository.findById(pollId).get();
        List<Voter> voters = voterRepository.findVotersByPollingDivision(pollingDivision);
        return entityDtoConvertor.convertToDtoList(voters);
    }

    @Override
    public List<VoterDTO> findVotersByGramaNiladari(GramaNiladariDTO gramaNiladariDTO) {
        List<Voter> votersByGramaNiladari = voterRepository.findVotersByGramaNiladari((GramaNiladari) entityDtoConvertor.convertToEntity(gramaNiladariDTO));
        return entityDtoConvertor.convertToDtoList(votersByGramaNiladari);
    }

    @Override
    public long getCount() {
        return voterRepository.count();
    }
}
