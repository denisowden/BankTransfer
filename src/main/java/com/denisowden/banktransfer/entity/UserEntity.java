package com.denisowden.banktransfer.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "user")
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<CardEntity> cardEntityList;

}
