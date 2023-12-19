package com.akerke.notification.service.impl;

import com.akerke.notification.dto.UserDTO;
import com.akerke.notification.entity.User;
import com.akerke.notification.mapper.UserMapper;
import com.akerke.notification.repository.UserRepository;
import com.akerke.notification.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
    public User findById(String id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User update(String id, UserDTO userDTO) {
        return null;
    }

    @Override
    public User delete(String id) {
        return null;
    }
}
