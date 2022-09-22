package com.denisowden.banktransfer.model;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardDto {
    private Integer id;
    private Integer number;
    private BigDecimal amount;
    private UserDto userDto;
}
