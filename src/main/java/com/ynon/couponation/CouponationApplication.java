package com.ynon.couponation;

import com.ynon.couponation.utils.ArtUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CouponationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouponationApplication.class, args);
		System.out.println(ArtUtils.machineRunning);
	}

}
