package com.ynon.couponation.dtos;

import com.ynon.couponation.enums.UserType;
import lombok.*;

import javax.persistence.Access;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

/**
 * Created by Ynon on  14-Aug-21
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {

    private long id;
    private String email;
    private String password;
    private Long companyId;
    private UserType type;
    private boolean isActivated;

}
