package com.akerke.notification.service;

import com.akerke.notification.dto.UserDTO;
import com.akerke.notification.entity.User;

import java.util.List;

public interface UserService {

    User create(UserDTO userDTO);

    User findById(String id);

    List<User> findAll();

    User update(String id, UserDTO userDTO);

    User delete(String id);

}
