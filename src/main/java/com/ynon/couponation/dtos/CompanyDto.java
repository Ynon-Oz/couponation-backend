package com.ynon.couponation.dtos;

import com.ynon.couponation.entities.Coupon;
import com.ynon.couponation.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.util.List;

/**
 * Created by Ynon on  15-Aug-21
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {

    private long id;
    private String name;
    private String phone;
    private String address;
    private String email;
    private String webSite;
    private List<User> users;
    private List<Coupon> coupons;
}
