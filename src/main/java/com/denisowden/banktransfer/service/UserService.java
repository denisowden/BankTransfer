package com.denisowden.banktransfer.service;

import com.denisowden.banktransfer.entity.UserEntity;
import com.denisowden.banktransfer.model.User;
import com.denisowden.banktransfer.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    public List<User> getUser() {
        return userRepository.
                findAll().
                stream().
                map(User::toModel).
                collect(Collectors.toList());
    }

    public Integer deleteUser(Integer id) {
        userRepository.deleteById(id);
        return id;
    }
}
