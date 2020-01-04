package im.vtngsystm.service.custom.impl;

import im.vtngsystm.dto.ContestantDTO;
import im.vtngsystm.entity.Contestant;
import im.vtngsystm.repository.ContestantRepository;
import im.vtngsystm.service.custom.ContestantService;
import im.vtngsystm.service.util.EntityDtoConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ContestantServiceImpl implements ContestantService {

    @Autowired
    ContestantRepository contestantRepository;

    @Autowired
    EntityDtoConvertor entityDtoConvertor;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(ContestantDTO dto) {
        Contestant entity = (Contestant) entityDtoConvertor.convertToEntity(dto);
        contestantRepository.save(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void update(int id, ContestantDTO dto) {
        if (dto.getContestId() != id) {
            throw new RuntimeException("Contestant ID mismatched");
        }
        if (contestantRepository.existsById(id)) {
            Contestant entity = (Contestant) entityDtoConvertor.convertToEntity(dto);
            contestantRepository.save(entity);
        } else {
            throw new RuntimeException("Contestant doesn't exist");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(int id) {
        contestantRepository.deleteById(id);
    }

    @Override
    public ContestantDTO findByID(int id) {
        Contestant byId = contestantRepository.findById(id).get();
        return (ContestantDTO) entityDtoConvertor.convertToDTO(byId);
    }

    @Override
    public ContestantDTO findByName(String name) {
        Contestant byName = contestantRepository.findContestantByNameEquals(name);
        return (ContestantDTO) entityDtoConvertor.convertToDTO(byName);
    }

    @Override
    public List<ContestantDTO> findAll() {
        List<Contestant> all = contestantRepository.findAll();
        return entityDtoConvertor.convertToDtoList(all);
    }

    @Override
    public long getCount() {
        return contestantRepository.count();
    }
}
