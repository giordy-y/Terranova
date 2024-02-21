package com.terranova.model.mapper;

import com.terranova.model.dto.UserDto;

import com.terranova.model.entity.User;


import java.util.List;

public class UsersMapper implements IDtoEntityBidirectionalMapper<UserDto,User>{

    @Override
    public List<UserDto> toDtos(List<User> entityList) {
        return IDtoEntityBidirectionalMapper.super.toDtos(entityList);
    }

    @Override
    public UserDto toDto(User user) {
        return new UserDto(
                user.getIDUser(),
                user.getNome(),
                user.getCognome(),
                user.getEmail(),
                user.getPassword()
        );
    }

    @Override
    public List<User> toEntities(List<UserDto> dtoList) {
       return IDtoEntityBidirectionalMapper.super.toEntities(dtoList);
    }

    @Override
    public User toEntity(UserDto dto) {
        return new User(
                dto.getId(),
                dto.getNome(),
                dto.getCognome(),
                dto.getEmail(),
                dto.getPassword()

        );
    }
}
