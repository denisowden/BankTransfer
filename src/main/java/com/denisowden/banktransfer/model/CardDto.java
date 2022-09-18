package com.denisowden.banktransfer.model;


import java.math.BigDecimal;

import com.denisowden.banktransfer.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardDto {
    private Integer id;
    private Integer number;
    private BigDecimal amount;
    private User user;
}
