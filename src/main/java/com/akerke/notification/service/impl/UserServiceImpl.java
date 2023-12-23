package com.akerke.notification.service.impl;

import com.akerke.notification.dto.UserDTO;
import com.akerke.notification.entity.User;
import com.akerke.notification.mapper.UserMapper;
import com.akerke.notification.repository.NotificationRepository;
import com.akerke.notification.repository.UserRepository;
import com.akerke.notification.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public User create(UserDTO userDTO) {
        var user = userMapper.toModel(userDTO);
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void update(Long id, UserDTO userDTO) {
        var user = this.findById(id);
        userMapper.update(userDTO, user);
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        var user = this.findById(id);
        userRepository.delete(user);
    }

}
