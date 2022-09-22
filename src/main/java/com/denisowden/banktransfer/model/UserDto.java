package com.denisowden.banktransfer.model;


import com.denisowden.banktransfer.entity.Card;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class UserDto {
    private Integer id;
    private String name;
    private String surName;
}
