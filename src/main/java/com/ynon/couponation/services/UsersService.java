package com.ynon.couponation.services;

import com.ynon.couponation.dtos.UserDto;
import com.ynon.couponation.entities.User;
import com.ynon.couponation.enums.ErrType;
import com.ynon.couponation.exceptions.ApplicationException;
import com.ynon.couponation.mapper.UserMapper;
import com.ynon.couponation.repositories.UsersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Ynon on  14-Aug-21
 */
@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepo usersRepository;
    private final UserMapper userMapper;

    //Create
    public UserDto createUser(UserDto user) {
        return userMapper.toDto(usersRepository.save(userMapper.toDao(user)));
    }

    //Retrieve
    //All
    public List<UserDto> getAllUsers() {
        return userMapper.toDtoList(usersRepository.findAll());
    }
    //Single
    public UserDto getUserById(long id) {
        return userMapper.toDto(usersRepository.findById(id).get());
    }
    //Update
    public UserDto updateUser(long id,UserDto user) throws ApplicationException {
        if(!usersRepository.existsById(id)){
            throw new ApplicationException(ErrType.USER_NOT_EXIST);
        }
        User u = usersRepository.findById(id).get();
        u.setPassword(user.getPassword());
        u.setType(user.getType());
        return userMapper.toDto(usersRepository.save(u));
    }
    //Delete
    public void deleteUser(long id) throws ApplicationException {
        if (!usersRepository.existsById(id)) {
            throw new ApplicationException(ErrType.USER_NOT_EXIST);
        }
        usersRepository.deleteById(id);
    }



}
