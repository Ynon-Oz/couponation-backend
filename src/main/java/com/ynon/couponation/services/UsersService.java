package com.ynon.couponation.services;

import com.ynon.couponation.dtos.UserDto;
import com.ynon.couponation.entities.User;
import com.ynon.couponation.enums.ErrType;
import com.ynon.couponation.exceptions.ApplicationException;
import com.ynon.couponation.repositories.UsersRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ynon on  14-Aug-21
 */
@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepo usersRepository;

    //Create
    public ResponseEntity<?> createUser(UserDto user) {
        return new ResponseEntity<>(usersRepository.save(turnUserDtoToUserEntity(user)), HttpStatus.CREATED);
    }

    //Retrieve
    //All
    public List<UserDto> getAllUsers() {
        List<User> users = usersRepository.findAll();
        List<UserDto> dtoUsers = new ArrayList<>();
        users.forEach(user -> dtoUsers.add(turnUserEntityToUserDto(user)));

        return dtoUsers;
    }

    //Update

    //Delete
    public void deleteUser(long id) throws ApplicationException {
        if( usersRepository.existsById(id)){
            throw new ApplicationException(ErrType.USER_NOT_EXIST);
        }
        usersRepository.deleteById(id);
    }

    //Entity to DTO
    private UserDto turnUserEntityToUserDto(User entity) {
        return UserDto.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .type(entity.getType())
                .build();
    }

    //DTO to Entity
    private User turnUserDtoToUserEntity(UserDto dto) {
        return User.builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .type(dto.getType())
                .build();
    }
}
