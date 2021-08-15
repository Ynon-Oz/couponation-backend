package com.ynon.couponation.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

/**
 * Created by Ynon on  15-Aug-21
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String phone;
    private String Address;
    @Email
    private String email;
    private String webSite;
    @OneToMany(mappedBy = "company" ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> users;
    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Coupon> coupons;
}
