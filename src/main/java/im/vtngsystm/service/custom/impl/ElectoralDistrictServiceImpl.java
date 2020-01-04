package im.vtngsystm.service.custom.impl;

import im.vtngsystm.dto.ElectoralDistrictDTO;
import im.vtngsystm.dto.PollingDivisionDTO;
import im.vtngsystm.entity.ElectoralDistrict;
import im.vtngsystm.repository.ElectoralDistrictRepository;
import im.vtngsystm.service.custom.ElectoralDistrictService;
import im.vtngsystm.service.util.EntityDtoConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ElectoralDistrictServiceImpl implements ElectoralDistrictService {

    @Autowired
    ElectoralDistrictRepository electoralDistrictRepository;

    @Autowired
    EntityDtoConvertor entityDtoConvertor;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(ElectoralDistrictDTO dto) {
        ElectoralDistrict electoralDistrict = (ElectoralDistrict) entityDtoConvertor.convertToEntity(dto);
        electoralDistrictRepository.save(electoralDistrict);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void update(int id, ElectoralDistrictDTO dto) {
        if (dto.getId() != id) {
            throw new RuntimeException("Electoral District ID mismatched");
        }
        if (electoralDistrictRepository.existsById(id)) {
            ElectoralDistrict electoralDistrict = (ElectoralDistrict) entityDtoConvertor.convertToEntity(dto);
            electoralDistrictRepository.save(electoralDistrict);
        } else {
            throw new RuntimeException("Electoral District doesn't exist");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(int id) {
        electoralDistrictRepository.deleteById(id);
    }

    @Override
    public ElectoralDistrictDTO findByID(int id) {
        ElectoralDistrict electoralDistrict = electoralDistrictRepository.findById(id).get();
        return (ElectoralDistrictDTO) entityDtoConvertor.convertToDTO(electoralDistrict);
    }

    @Override
    public ElectoralDistrictDTO findByName(String name) {
        ElectoralDistrict electoralDistrictByDistName = electoralDistrictRepository.findElectoralDistrictByDistName(name);
        return (ElectoralDistrictDTO) entityDtoConvertor.convertToDTO(electoralDistrictByDistName);
    }

    @Override
    public List<ElectoralDistrictDTO> findAll() {
        List<ElectoralDistrict> all = electoralDistrictRepository.findAll();
        return entityDtoConvertor.convertToDtoList(all);
    }

    @Override
    public long getCount() {
        return electoralDistrictRepository.count();
    }

    @Override
    public List<PollingDivisionDTO> findPollingDivisionsByDistrict(String name) {
        ElectoralDistrictDTO byName = findByName(name);
        return byName.getPollingDivisionDTOS();
    }
}
