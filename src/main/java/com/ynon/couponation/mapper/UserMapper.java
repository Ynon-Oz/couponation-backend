package com.ynon.couponation.mapper;

import com.ynon.couponation.dtos.UserDto;
import com.ynon.couponation.entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ynon on  15-Aug-21
 */
@Component
public class UserMapper implements Mapper<User, UserDto>{


    @Override
    public User toDao(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .type(userDto.getType())
                .build();
    }

    @Override
    public UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .type(user.getType())
                .build();
    }

    @Override
    public List<User> toDaoList(List<UserDto> userDtos) {
        List<User> users = new ArrayList<>();
        userDtos.forEach(userDto -> users.add(toDao(userDto)));
        return users;
    }

    @Override
    public List<UserDto> toDtoList(List<User> users) {
        List<UserDto> dtos = new ArrayList<>();
        users.forEach(user -> dtos.add(toDto(user)));
        return dtos;
    }
}
