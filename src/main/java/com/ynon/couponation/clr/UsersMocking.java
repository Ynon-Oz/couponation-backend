package com.ynon.couponation.clr;

import com.ynon.couponation.dtos.UserDto;
import com.ynon.couponation.entities.User;
import com.ynon.couponation.enums.UserType;
import com.ynon.couponation.mapper.UserMapper;
import com.ynon.couponation.services.UsersService;
import com.ynon.couponation.utils.ArtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by Ynon on  15-Aug-21
 */
@Component
public class UsersMocking implements CommandLineRunner {
    @Autowired
    private UsersService usersService;
    @Autowired
    private UserMapper userMapper;

    @Override
    public void run(String... args) throws Exception {

//        PrintStream out = new PrintStream(
//                new FileOutputStream("userstesting.log", true), true);
//        System.setOut(out);

        System.out.println(ArtUtils.stratingUsersTests);

        UserDto u1 = UserDto.builder()
                .type(UserType.ADMIN)
                .email("admin@admin.com")
                .password("12345678")
                .build();
        UserDto u2 = UserDto.builder()
                .type(UserType.COMPANY)
                .email("company@company.com")
                .password("12345678")
                .build();
        UserDto u3 = UserDto.builder()
                .type(UserType.CUSTOMER)
                .email("customer1@gmail.com")
                .password("12345678")
                .build();
        UserDto u4 = UserDto.builder()
                .type(UserType.CUSTOMER)
                .email("customer2@gmail.com")
                .password("12345678")
                .build();
        System.out.println("Adding User: " + u1);
        System.out.println(usersService.createUser(u1));
        System.out.println("Adding User: " + u2);
        System.out.println(usersService.createUser(u2));
        System.out.println("Adding User: " + u3);
        System.out.println(usersService.createUser(u3));
        System.out.println("Adding User: " + u4);
        System.out.println(usersService.createUser(u4));
        System.out.println("********************************************************************");
        System.out.println("Deleting User id# 3");
        usersService.deleteUser(3);
        System.out.println("********************************************************************");
        UserDto updateUser = usersService.getUserById(4);
        System.out.println("Updating User#4: " + updateUser);
        updateUser.setPassword("87654321");
        System.out.println(usersService.updateUser(4, updateUser));
        System.out.println("********************************************************************");
        System.out.println("Get all users:");
        usersService.getAllUsers().forEach(System.out::println);
        System.out.println("********************************************************************");


    }
}
