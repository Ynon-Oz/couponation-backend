package com.ynon.couponation.controllers;

import com.ynon.couponation.dtos.UserDto;
import com.ynon.couponation.exceptions.ApplicationException;
import com.ynon.couponation.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ynon on  14-Aug-21
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    //CREATE
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public @ResponseBody
    UserDto addUser(@RequestBody UserDto user) {
        return this.usersService.createUser(user);
    }

    //RETRIEVE
    @GetMapping
    public List<UserDto> getAllUsers() {
        return this.usersService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable long id) {
        return this.usersService.getUserById(id);
    }

    //UPDATE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable long id, @RequestBody UserDto user) throws ApplicationException {
        return this.usersService.updateUser(id, user);
    }

    //DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable long id) throws ApplicationException {
        this.usersService.deleteUser(id);
    }

}
