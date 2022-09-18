package com.denisowden.banktransfer.mapper;

import com.denisowden.banktransfer.entity.User;
import com.denisowden.banktransfer.model.UserDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

  UserDto toDto(User user);

  User toEntity(UserDto userDto);
}
