package im.vtngsystm.service;

import im.vtngsystm.dto.SuperDTO;

import java.util.List;

public interface SuperService<T extends SuperDTO> {

    void save(T dto);

    void update(int id, T dto);

    void delete(int id);

    T findByID(int id);

    T findByName(String name);

    List<T> findAll();

    long getCount();
}
