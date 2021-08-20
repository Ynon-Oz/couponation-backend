package com.ynon.couponation.entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "companies")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "companyID")
    private long id;

    @Column(name = "Name",  nullable = false)
    private String name;

    @Column(name = "Address", nullable = false)
    private String address;

    @Column(name = "PhoneNum", nullable = false)
    private String phone;

    @Column(name = "Email")
    private String email;

    @Column(name = "Website", unique = true)
    private String website;
    @ToString.Exclude
    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    private List<Coupon> coupons;
    @JsonIgnore
    @OneToMany(mappedBy = "companyId", cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<User> users;


//    public Company(String name, String address, String phone, String fax, String web) {
//        super();
//        this.name = name;
//        this.address = address;
//        this.phone = phone;
//        this.email = fax;
//        this.website = web;
//    }
}

