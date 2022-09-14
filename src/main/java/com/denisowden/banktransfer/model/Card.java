package com.denisowden.banktransfer.model;

import com.denisowden.banktransfer.entity.CardEntity;
import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.Optional;

@Data
public class Card {
    private Integer id;
    private Integer number;
    private BigDecimal amount;
    private String name;
    private String surName;
    private Integer user_id;

    public static Card toModel(CardEntity entity){
        Card card = new Card();
        card.setId(entity.getId());
        card.setNumber(entity.getNumber());
        card.setAmount(entity.getAmount());
        card.setName(entity.getUser().getName());
        card.setSurName(entity.getUser().getSurName());
        card.setUser_id(entity.getUser().getId());
        return card;
    }
}
