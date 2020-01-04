package im.vtngsystm.service;

import im.vtngsystm.dto.UserDTO;

import java.util.List;

public interface UserService<T extends UserDTO> {

    void save(String id, T dto);

    void update(String id, T dto);

    void delete(String id);

    T findByID(String id);

    T findByName(String name);

    List<T> findAll();

    default boolean logIn(UserDTO user) {
        T byID = findByID(user.getUsername());
        if (null == byID) return false;
        return (byID.getPassword()).equals(user.getPassword());
    }

    long getCount();
}
