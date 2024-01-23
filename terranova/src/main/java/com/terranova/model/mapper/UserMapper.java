package com.terranova.model.mapper;

import com.terranova.model.dto.UserDto;
import com.terranova.model.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper implements IDtoEntityBidirectionalMapper<UserDto,User> {

    @Override
    public UserDto toDto(User user) {
        return new UserDto(
                user.getId(),
                user.getNome(),
                user.getCognome(),
                user.getMail()
        );
    }

    @Override
    public List<UserDto> toDtos(List<User> entityList) {
        return IDtoEntityBidirectionalMapper.super.toDtos(entityList);
    }



    @Override
    public User toEntity(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getNome(),
                userDto.getCognome(),
                userDto.getMail()
        );
    }
    @Override
    public List<User> toEntities(List<UserDto> dtoList) {
        return IDtoEntityBidirectionalMapper.super.toEntities(dtoList);
    }
}
