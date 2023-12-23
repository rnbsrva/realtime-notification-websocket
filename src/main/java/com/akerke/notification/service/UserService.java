package com.akerke.notification.service;

import com.akerke.notification.dto.UserDTO;
import com.akerke.notification.entity.User;

import java.util.List;

public interface UserService {

    User create(UserDTO userDTO);

    User findById(Long id);

    List<User> findAll();

    void update(Long id, UserDTO userDTO);

    void delete(Long id);

}
