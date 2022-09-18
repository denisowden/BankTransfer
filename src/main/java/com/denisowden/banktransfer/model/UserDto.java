package com.denisowden.banktransfer.model;

import com.denisowden.banktransfer.entity.User;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserDto {
    private Integer id;
    private String name;
    private String surName;
    private List<CardDto> cardDtos;
}
