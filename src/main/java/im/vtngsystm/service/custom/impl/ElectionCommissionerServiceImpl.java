package im.vtngsystm.service.custom.impl;

import im.vtngsystm.dto.ElectionCommissionerDTO;
import im.vtngsystm.entity.ElectionCommissioner;
import im.vtngsystm.repository.ElectionCommissionerRepository;
import im.vtngsystm.service.custom.ElectionCommissionerService;
import im.vtngsystm.service.util.EntityDtoConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ElectionCommissionerServiceImpl implements ElectionCommissionerService {

    @Autowired
    EntityDtoConvertor entityDtoConvertor;
    @Autowired
    private ElectionCommissionerRepository electionCommissionerRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(String id, ElectionCommissionerDTO dto) {
        if (dto.getUsername().equals(id)) {
            throw new RuntimeException("Election Commissioner ID mismatched");
        }
        ElectionCommissioner entity = (ElectionCommissioner) entityDtoConvertor.convertToEntity(dto);
        electionCommissionerRepository.save(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void update(String id, ElectionCommissionerDTO dto) {
        if (dto.getUsername().equals(id)) {
            throw new RuntimeException("Election Commissioner ID mismatched");
        }
        if (electionCommissionerRepository.existsById(dto.getUsername())) {
            ElectionCommissioner entity = (ElectionCommissioner) entityDtoConvertor.convertToEntity(dto);
            electionCommissionerRepository.save(entity);
        } else {
            throw new RuntimeException("Election Commissioner doesn't exist");
        }
    }

    @Override
    public void delete(String id) {
        electionCommissionerRepository.deleteById(id);
    }

    @Override
    public ElectionCommissionerDTO findByID(String id) {
        ElectionCommissioner electionCommissioner = electionCommissionerRepository.findById(id).get();
        return (ElectionCommissionerDTO) entityDtoConvertor.convertToDTO(electionCommissioner);
    }


    @Override
    public ElectionCommissionerDTO findByName(String name) {
        ElectionCommissioner e = electionCommissionerRepository.findElectionCommissionerByName(name);
        return (ElectionCommissionerDTO) entityDtoConvertor.convertToDTO(e);
    }

    @Override
    public List<ElectionCommissionerDTO> findAll() {
        List<ElectionCommissioner> all = electionCommissionerRepository.findAll();
        return entityDtoConvertor.convertToDtoList(all);
    }

    @Override
    public long getCount() {
        return electionCommissionerRepository.count();
    }
}
