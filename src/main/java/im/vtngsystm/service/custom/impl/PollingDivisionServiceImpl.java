package im.vtngsystm.service.custom.impl;

import im.vtngsystm.dto.ContestantDTO;
import im.vtngsystm.dto.PollingDivisionDTO;
import im.vtngsystm.entity.PollingDivision;
import im.vtngsystm.repository.PollingDivisionRepository;
import im.vtngsystm.service.custom.PollingDivisionService;
import im.vtngsystm.service.util.EntityDtoConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PollingDivisionServiceImpl implements PollingDivisionService {

    @Autowired
    EntityDtoConvertor entityDtoConvertor;
    @Autowired
    private PollingDivisionRepository pollingDivisionRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(PollingDivisionDTO dto) {
        PollingDivision pollingDivision = (PollingDivision) entityDtoConvertor.convertToEntity(dto);
        pollingDivisionRepository.save(pollingDivision);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void update(int id, PollingDivisionDTO dto) {
        if (dto.getPollId() != id) {
            throw new RuntimeException("Polling Division ID mismatched");
        }
        if (pollingDivisionRepository.existsById(id)) {
            PollingDivision entity = (PollingDivision) entityDtoConvertor.convertToEntity(dto);
            pollingDivisionRepository.save(entity);
        } else {
            throw new RuntimeException("Polling Division doesn't exist");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(int id) {
        pollingDivisionRepository.deleteById(id);
    }

    @Override
    public PollingDivisionDTO findByID(int id) {
        PollingDivision pollingDivision = pollingDivisionRepository.findById(id).get();
        return (PollingDivisionDTO) entityDtoConvertor.convertToDTO(pollingDivision);
    }

    @Override
    public PollingDivisionDTO findByName(String name) {
        PollingDivision pollingDivisionByPollNameIs = pollingDivisionRepository.findPollingDivisionByPollNameIs(name);
        return (PollingDivisionDTO) entityDtoConvertor.convertToDTO(pollingDivisionByPollNameIs);
    }

    @Override
    public List<PollingDivisionDTO> findAll() {
        List<PollingDivision> all = pollingDivisionRepository.findAll();
        return entityDtoConvertor.convertToDtoList(all);
    }

    @Override
    public long getCount() {
        return pollingDivisionRepository.count();
    }

    @Override
    public List<ContestantDTO> findContestantsByPollingDivisionAndParty(String details) {
        String[] split = details.split(",");
        System.out.println(Arrays.toString(split));
        PollingDivisionDTO byName = findByName(split[0]);
        List<ContestantDTO> contestants = byName.getContestants();
        List<ContestantDTO> partyContestants = new ArrayList<>();
        for (ContestantDTO contestantDTO : contestants
        ) {
            if (split[1].equals(contestantDTO.getParty()))
                partyContestants.add(contestantDTO);
        }
        return partyContestants;
    }
}
