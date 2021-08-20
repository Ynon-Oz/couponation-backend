package com.ynon.couponation.entities;

import com.ynon.couponation.enums.UserType;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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
    @NotBlank
    private String email;
    @Size(min = 8, max = 12)
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType type;
    @ManyToOne
    @JoinColumn(name = "companyId")
    private Company company;


}
