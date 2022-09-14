package com.denisowden.banktransfer.controller;

import com.denisowden.banktransfer.entity.UserEntity;
import com.denisowden.banktransfer.model.User;
import com.denisowden.banktransfer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user){
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getUser(){
        return userService.getUser();
    }

    @DeleteMapping(value = "/{id}")
    public Integer deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }
}
