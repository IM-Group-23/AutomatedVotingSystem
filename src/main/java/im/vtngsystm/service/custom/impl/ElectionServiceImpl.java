package im.vtngsystm.service.custom.impl;

import im.vtngsystm.dto.ElectionContestantDTO;
import im.vtngsystm.dto.ElectionDTO;
import im.vtngsystm.entity.Election;
import im.vtngsystm.repository.ElectionRepository;
import im.vtngsystm.service.custom.ContestantService;
import im.vtngsystm.service.custom.ElectionService;
import im.vtngsystm.service.util.EntityDtoConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ElectionServiceImpl implements ElectionService {

    @Autowired
    ElectionRepository electionRepository;

    @Autowired
    EntityDtoConvertor entityDtoConvertor;

    @Autowired
    ContestantService contestantService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(ElectionDTO dto) {
        List<ElectionContestantDTO> candidates = dto.getCandidates();
        for (ElectionContestantDTO candidate : candidates) {
            candidate.setContestID(contestantService.findByName(candidate.getContestName()).getContestId());
        }
        Election entity = (Election) entityDtoConvertor.convertToEntity(dto);
        electionRepository.save(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void update(int id, ElectionDTO dto) {
        if (dto.getId() != id) {
            throw new RuntimeException("Election ID mismatched");
        }
        if (electionRepository.existsById(id)) {
            Election entity = (Election) entityDtoConvertor.convertToEntity(dto);
            electionRepository.save(entity);
        } else {
            throw new RuntimeException("Election doesn't exist");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(int id) {
        electionRepository.deleteById(id);
    }

    @Override
    public ElectionDTO findByID(int id) {
        Election election = electionRepository.findById(id).get();
        return (ElectionDTO) entityDtoConvertor.convertToDTO(election);
    }

    @Override
    public ElectionDTO findByName(String name) {        //elections name is in the form of "Election Type - YYYY.MM.DD"
        String[] split = name.split("-");
        String electionType = split[0];
        String dateString = split[1];
        String[] split1 = dateString.split(".");
        LocalDate date = LocalDate.of(Integer.parseInt(split1[0]), Integer.parseInt(split1[1]) - 1, Integer.parseInt(split1[2]));
        Election electionByDateAndType = electionRepository.findElectionByDateAndType(date, electionType);
        return (ElectionDTO) entityDtoConvertor.convertToDTO(electionByDateAndType);
    }

    @Override
    public List<ElectionDTO> findAll() {
        List<Election> all = electionRepository.findAllByDateChronology();
        return entityDtoConvertor.convertToDtoList(all);
    }

    @Override
    public long getCount() {
        return electionRepository.count();
    }

    @Override
    public ElectionDTO getCurrentElection() {
        LocalDate now = LocalDate.now();
        System.out.println(now.toString());
        Election electionByDate = electionRepository.findElectionByDate(now);
        return (ElectionDTO) entityDtoConvertor.convertToDTO(electionByDate);
    }
}
