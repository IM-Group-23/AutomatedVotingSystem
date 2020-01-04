package im.vtngsystm.service.custom.impl;

import im.vtngsystm.dto.ElectoralDistrictDTO;
import im.vtngsystm.dto.ProvinceDTO;
import im.vtngsystm.entity.Province;
import im.vtngsystm.repository.ProvinceRepository;
import im.vtngsystm.service.custom.ProvinceService;
import im.vtngsystm.service.util.EntityDtoConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    EntityDtoConvertor entityDtoConvertor;
    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(ProvinceDTO dto) {
        Province province = (Province) entityDtoConvertor.convertToEntity(dto);
        provinceRepository.save(province);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void update(int id, ProvinceDTO dto) {
        if (dto.getId() != id) {
            throw new RuntimeException("Province ID mismatched");
        }
        if (provinceRepository.existsById(id)) {
            Province entity = (Province) entityDtoConvertor.convertToEntity(dto);
            provinceRepository.save(entity);
        } else {
            throw new RuntimeException("Province doesn't exist");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(int id) {
        provinceRepository.deleteById(id);
    }

    @Override
    public ProvinceDTO findByID(int id) {
        Province province = provinceRepository.findById(id).get();
        return (ProvinceDTO) entityDtoConvertor.convertToDTO(province);
    }

    @Override
    public ProvinceDTO findByName(String name) {
        Province province = provinceRepository.findProvinceByProvName(name);
        return (ProvinceDTO) entityDtoConvertor.convertToDTO(province);
    }

    @Override
    public List<ProvinceDTO> findAll() {
        return entityDtoConvertor.convertToDtoList(provinceRepository.findAll());
    }

    @Override
    public long getCount() {
        return provinceRepository.count();
    }

    @Override
    public List<ElectoralDistrictDTO> findDistrictByProvince(String name) {
        ProvinceDTO byName = findByName(name);
        return byName.getElectoralDistrictDTOS();
    }
}
