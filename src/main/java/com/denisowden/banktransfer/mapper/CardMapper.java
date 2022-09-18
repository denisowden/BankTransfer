package com.denisowden.banktransfer.mapper;

import com.denisowden.banktransfer.entity.Card;
import com.denisowden.banktransfer.model.CardDto;
import org.mapstruct.Mapper;

@Mapper
public interface CardMapper {

  CardDto toDto(Card card);
}
