package im.vtngsystm.service.custom;

import im.vtngsystm.dto.PartyDTO;
import im.vtngsystm.service.SuperService;

public interface PartyService extends SuperService<PartyDTO> {

    @Override
    default void update(int id, PartyDTO dto) {
        System.out.println("this method is not valid for this service");
        throw new RuntimeException("Invalid method in service");
    }

    @Override
    default void delete(int id) {
        System.out.println("this method is not valid for this service");
        throw new RuntimeException("Invalid method in service");
    }

    @Override
    default PartyDTO findByID(int id) {
        System.out.println("this method is not valid for this service");
        throw new RuntimeException("Invalid method in service");
    }

    @Override
    default PartyDTO findByName(String name) {
        System.out.println("this method is not valid for this service");
        throw new RuntimeException("Invalid method in service");
    }

    @Override
    default void save(PartyDTO dto) {
        System.out.println("this method is not valid for this service");
        throw new RuntimeException("Invalid method in service");
    }

    void save(String id, PartyDTO partyDTO);

    void update(String id, PartyDTO dto);

    void delete(String id);

    PartyDTO findByID(String id);
}
