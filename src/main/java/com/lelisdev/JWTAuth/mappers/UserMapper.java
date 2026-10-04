package com.lelisdev.JWTAuth.mappers;

import com.lelisdev.JWTAuth.dtos.UserLoginDto;
import com.lelisdev.JWTAuth.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserLoginDto userToUserLoginDto(User user);
}
