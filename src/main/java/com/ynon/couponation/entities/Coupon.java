package com.ynon.couponation.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coupons")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Validated
@Builder
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private long id;
    //	@NotNull
    @JoinColumn(name = "companyId")//, insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Company company;

    //TODO Change CouponCategory to Entity

    @JoinColumn(name = "categoryId", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private CouponCategory type;
    @Size(min = 2, max = 22)
    @Column(name = "title", nullable = false)
    private String title;
    @NotBlank
    @Column(name = "description", nullable = false)
    private String description;
    //	@PastOrPresent
    @Column(name = "startDate", nullable = false)
    private LocalDateTime startDate;
    //	@FutureOrPresent
    @Column(name = "endDate", nullable = false)
    private LocalDateTime endDate;
    @Positive
    @Column(name = "amount", nullable = false)
    private int amount;
    @Positive
    @Column(name = "price", nullable = false)
    private float price;
    //TODO Change to object to enable saving images
//	@Column(name = "image")
//	private String image;
    @JsonProperty(value = "image")
    private UUID image;

    @OneToMany(mappedBy = "coupon", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Purchase> purchases;


//    public Coupon(long id, Company company, CouponCategory type, String title, String description, LocalDateTime startDate,
//                  LocalDateTime endDate, int amount, float price, UUID image) {
//        this.id = id;
//        this.company = company;
//        this.type = type;
//        this.title = title;
//        this.description = description;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.amount = amount;
//        this.price = price;
//        this.image = image;
//        this.purchases = null;
//    }

//	public Coupon(long id, Company company, CouponCategory type, String title, String description, LocalDateTime startDate,
//				  LocalDateTime endDate, int amount, float price, String image) {
//		this.id = id;
//		this.company = company;
//		this.type = type;
//		this.title = title;
//		this.description = description;
//		this.startDate = startDate;
//		this.endDate = endDate;
//		this.amount = amount;
//		this.price = price;
//		this.image = image;
//		this.purchases = null;
//	}


//    public Coupon(Company company, CouponCategory type, String title, String description, LocalDateTime startDate, LocalDateTime endDate,
//                  int amount, float price, UUID image) {
//        this.company = company;
//        this.type = type;
//        this.title = title;
//        this.description = description;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.amount = amount;
//        this.price = price;
//        this.image = image;
//        this.purchases = null;
//    }


}


