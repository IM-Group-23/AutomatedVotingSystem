package im.vtngsystm.service.custom.impl;

import im.vtngsystm.dto.PartyDTO;
import im.vtngsystm.entity.Party;
import im.vtngsystm.repository.PartyRepository;
import im.vtngsystm.service.custom.PartyService;
import im.vtngsystm.service.util.EntityDtoConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PartyServiceImpl implements PartyService {

    @Autowired
    EntityDtoConvertor entityDtoConvertor;
    @Autowired
    private PartyRepository partyRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(String id, PartyDTO partyDTO) {
        if (!(id.equals(partyDTO.getPartyInitials()))) {
            throw new RuntimeException("Party Initials doesn't match");
        }
        Party party = (Party) entityDtoConvertor.convertToEntity(partyDTO);
        partyRepository.save(party);
    }

    @Override
    public List<PartyDTO> findAll() {
        List<Party> all = partyRepository.findAll();
        return entityDtoConvertor.convertToDtoList(all);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void update(String id, PartyDTO dto) {
        if (!dto.getPartyInitials().equals(id)) {
            throw new RuntimeException("Party Initials mismatched");
        }
        if (partyRepository.existsById(id)) {
            Party entity = (Party) entityDtoConvertor.convertToEntity(dto);
            partyRepository.save(entity);
        } else {
            throw new RuntimeException("Party doesn't exist");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(String id) {
        partyRepository.deleteById(id);
    }

    @Override
    public PartyDTO findByID(String id) {
        Party party = partyRepository.findById(id).get();
        return (PartyDTO) entityDtoConvertor.convertToDTO(party);
    }

    @Override
    public long getCount() {
        return partyRepository.count();
    }
}
