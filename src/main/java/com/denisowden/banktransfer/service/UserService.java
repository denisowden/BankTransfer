package com.denisowden.banktransfer.service;

import com.denisowden.banktransfer.entity.User;
import com.denisowden.banktransfer.mapper.UserMapper;
import com.denisowden.banktransfer.model.UserDto;
import com.denisowden.banktransfer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<UserDto> getUser() {
        return userRepository.findAll().stream()
            .map(userMapper::toDto)
            .toList();
    }

    public Integer deleteUser(Integer id) {
        userRepository.deleteById(id);
        return id;
    }
}
