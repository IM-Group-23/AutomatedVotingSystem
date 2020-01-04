package im.vtngsystm.service.custom.impl;

import im.vtngsystm.dto.FingerprintDTO;
import im.vtngsystm.entity.Fingerprint;
import im.vtngsystm.repository.ElectionCommissionerRepository;
import im.vtngsystm.repository.FingerprintRepository;
import im.vtngsystm.repository.GramaNiladariRepository;
import im.vtngsystm.repository.VoterRepository;
import im.vtngsystm.service.custom.FingerprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FingerprintServiceImpl implements FingerprintService {

    @Autowired
    FingerprintRepository fingerprintRepository;

    @Autowired
    ElectionCommissionerRepository electionCommissionerRepository;

    @Autowired
    GramaNiladariRepository gramaNiladariRepository;

    @Autowired
    VoterRepository voterRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(String key) {
        fingerprintRepository.deleteById(key);
    }

    @Override
    public FingerprintDTO findById(String key) {
        Fingerprint fingerprint = fingerprintRepository.findById(key).get();
        return null;
//        return (FingerprintDTO) convertToDTO(fingerprint);
    }

    @Override
    public List<FingerprintDTO> findFingerprintsByUser(String username) {
        String substring = username.substring(0, 2);
        System.out.println(substring);
        List<Fingerprint> fingerprints = new ArrayList<>();
        if (substring.equals("ELC")) {
            fingerprints = fingerprintRepository.findFingerprintsByElectionCommissioner(electionCommissionerRepository.findById(username.substring(3)).get());
        } else if (substring.equals("GRN")) {
            fingerprints = fingerprintRepository.findFingerprintsByGramaNiladari(gramaNiladariRepository.findById(username.substring(3)).get());
        } else if (substring.equals("NIC")) {
            fingerprints = fingerprintRepository.findFingerprintsByVoter(voterRepository.findById(username.substring(3)).get());
        }
//        return convertToDtoList(fingerprints);
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(FingerprintDTO dto) {
//        Fingerprint fingerprint = (Fingerprint) convertToEntity(dto);
//        fingerprintRepository.save(fingerprint);
    }

    @Override
    public List<FingerprintDTO> findAll() {
        List<Fingerprint> all = fingerprintRepository.findAll();
//        return convertToDtoList(all);
        return null;
    }

    @Override
    public long getCount() {
        return 0;
    }
}
