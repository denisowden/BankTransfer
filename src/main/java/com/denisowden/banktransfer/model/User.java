package com.denisowden.banktransfer.model;

import com.denisowden.banktransfer.entity.UserEntity;
import com.denisowden.banktransfer.exception.NoCardsException;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class User {
    private Integer id;
    private String name;
    private String surName;
    private List<Card> cards;

    public static User toModel(UserEntity entity){
        User user = new User();
        user.setId(entity.getId());
        user.setName(entity.getName());
        user.setSurName(entity.getSurName());
        user.setCards(entity.
                    getCardEntityList().
                    stream().
                    map(Card::toModel).
                    collect(Collectors.toList()));



        return user;
    }
}
