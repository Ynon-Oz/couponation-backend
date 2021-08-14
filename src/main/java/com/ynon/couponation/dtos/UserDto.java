package com.ynon.couponation.dtos;

import com.ynon.couponation.enums.UserType;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

/**
 * Created by Ynon on  14-Aug-21
 */
@Data
@Builder
public class UserDto {

    private long id;
    private String email;
    private String password;
    private UserType type;
}
