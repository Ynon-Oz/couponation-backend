package com.ynon.couponation.mapper;

import com.ynon.couponation.dtos.UserDto;
import com.ynon.couponation.entities.Company;
import com.ynon.couponation.entities.User;
import com.ynon.couponation.exceptions.ApplicationException;
import com.ynon.couponation.repositories.CompanyRepo;
import com.ynon.couponation.services.CompaniesService;
import com.ynon.couponation.services.UsersService;
import lombok.Singular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ynon on  15-Aug-21
 */
@Component
public class UserMapper implements Mapper<User, UserDto> {

    @Autowired
    private CompanyRepo companyRepo;


    @Override
    public User toDao(UserDto dto) throws ApplicationException {
        User u = new User();
        u.setEmail(dto.getEmail());
        u.setPassword(dto.getPassword());
        u.setType(dto.getType());
        u.setActivated(dto.isActivated());
        if (dto.getCompanyId() != null) {
            u.setCompanyId(companyRepo.getOne(dto.getCompanyId()));
        } else {
            u.setCompanyId(null);
        }
        return u;
    }

    @Override
    public UserDto toDto(User user) {
        UserDto u = new UserDto();
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setType(user.getType());
        u.setId(user.getId());
        if(user.getCompanyId()!=null){
            u.setCompanyId(user.getCompanyId().getId());
        }else{u.setCompanyId(null);}
        return u;

    }

    @Override
    public List<User> toDaoList(List<UserDto> userDtos) throws ApplicationException {
        List<User> users = new ArrayList<>();
        userDtos.forEach(userDto -> {
            try {
                users.add(toDao(userDto));
            } catch (ApplicationException e) {
                e.printStackTrace();
            }
        });
        return users;
    }

    @Override
    public List<UserDto> toDtoList(List<User> users) {
        List<UserDto> dtos = new ArrayList<>();
        users.forEach(user -> dtos.add(toDto(user)));
        return dtos;
    }
}
