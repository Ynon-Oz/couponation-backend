package com.ynon.couponation.entities;

import com.ynon.couponation.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

/**
 * Created by Ynon on  14-Aug-21
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Email
    private String email;
    @Size(min = 8, max = 12)
    private String password;
    @Enumerated
    private UserType type;


}