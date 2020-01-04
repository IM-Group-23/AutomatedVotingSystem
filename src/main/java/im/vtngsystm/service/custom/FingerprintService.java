package im.vtngsystm.service.custom;

import im.vtngsystm.dto.FingerprintDTO;
import im.vtngsystm.service.SuperService;

import java.util.List;

public interface FingerprintService extends SuperService<FingerprintDTO> {

    void delete(String key);

    FingerprintDTO findById(String key);

    List<FingerprintDTO> findFingerprintsByUser(String username);

    @Override
    default void update(int id, FingerprintDTO dto) {
        System.out.println("method not supported for this service");
        throw new RuntimeException("Invalid method in service");
    }

    @Override
    default void delete(int id) {
        System.out.println("method not supported for this service");
        throw new RuntimeException("Invalid method in service");
    }

    @Override
    default FingerprintDTO findByID(int id) {
        System.out.println("method not supported for this service");
        return null;
    }

    @Override
    default FingerprintDTO findByName(String name) {
        System.out.println("method not supported for this service");
        return null;
    }
}
