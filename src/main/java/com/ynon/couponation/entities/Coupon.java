package com.ynon.couponation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //    @NotNull
    @JoinColumn(name = "companyId")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Company company;

    @JoinColumn(name = "categoryId")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private CouponCategory type;
    @Size(min = 2, max = 22)
//    @Column(name = "title",  nullable = false)
    private String title;
    private String description;
    private LocalDate startDate;
    //    @Column(name = "endDate",  nullable = false)
    private LocalDate endDate;
    @Positive
//    @Column(name = "amount",  nullable = false)
    private int amount;
    @Positive
//    @Column(name = "price",  nullable = false)
    private float price;
    //TODO Change to object to enable saving images
//    @Column(name = "image")
    private String image;

//    @OneToMany(mappedBy = "coupon", cascade = CascadeType.REMOVE)
//    @JsonIgnore
//    private List<Purchase> purchases;
}
