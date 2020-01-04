package im.vtngsystm.service.custom.impl;

import im.vtngsystm.dto.GramaNiladariDTO;
import im.vtngsystm.entity.GramaNiladari;
import im.vtngsystm.repository.GramaNiladariRepository;
import im.vtngsystm.service.custom.GramaNiladariService;
import im.vtngsystm.service.util.EntityDtoConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class GramaNiladariServiceImpl implements GramaNiladariService {

    @Autowired
    EntityDtoConvertor entityDtoConvertor;
    @Autowired
    private GramaNiladariRepository gramaNiladariRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(String id, GramaNiladariDTO dto) {
        System.out.println("------------------------------------------" + id + dto);
        if (dto.getUsername().equals(id)) {
            throw new RuntimeException("Grama Niladari's ID mismatched");
        }
        GramaNiladari entity = (GramaNiladari) entityDtoConvertor.convertToEntity(dto);
        gramaNiladariRepository.save(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void update(String id, GramaNiladariDTO dto) {
        if (dto.getUsername().equals(id)) {
            throw new RuntimeException("Grama Niladari's ID mismatched");
        }
        if (gramaNiladariRepository.existsById(dto.getUsername())) {
            GramaNiladari entity = (GramaNiladari) entityDtoConvertor.convertToEntity(dto);
            gramaNiladariRepository.save(entity);
        } else {
            throw new RuntimeException("Such Grama Niladari doesn't exist");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(String id) {
        gramaNiladariRepository.deleteById(id);
    }

    @Override
    public GramaNiladariDTO findByID(String id) {
        GramaNiladari gramaNiladari = gramaNiladariRepository.findById(id).get();
        return (GramaNiladariDTO) entityDtoConvertor.convertToDTO(gramaNiladari);
    }

    @Override
    public GramaNiladariDTO findByName(String name) {
        GramaNiladari gramaNiladari = gramaNiladariRepository.findGramaNiladariByName(name);
        return (GramaNiladariDTO) entityDtoConvertor.convertToDTO(gramaNiladari);
    }

    @Override
    public List<GramaNiladariDTO> findAll() {
        List<GramaNiladari> all = gramaNiladariRepository.findAll();
        return entityDtoConvertor.convertToDtoList(all);
    }

    @Override
    public long getCount() {
        return gramaNiladariRepository.count();
    }
}
