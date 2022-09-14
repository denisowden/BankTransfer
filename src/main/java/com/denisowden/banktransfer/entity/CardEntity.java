package com.denisowden.banktransfer.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name= "card")
@NoArgsConstructor
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer number;
    private BigDecimal amount;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
