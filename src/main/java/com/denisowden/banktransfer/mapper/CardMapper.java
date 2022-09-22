package com.denisowden.banktransfer.mapper;

import com.denisowden.banktransfer.entity.Card;
import com.denisowden.banktransfer.model.CardDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = UserMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CardMapper {

  @Mapping(target = "userDto", source = "user")
  CardDto toDto(Card card);
}
