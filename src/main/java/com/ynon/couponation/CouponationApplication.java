package com.ynon.couponation;

import com.ynon.couponation.utils.ArtUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CouponationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouponationApplication.class, args);
		System.out.println(ArtUtils.machineRunning);
		System.out.println("Test me with Postman:");
		System.out.println("https://www.postman.com/ynonoz/workspace/couponation/collection/15672485-ca08dcfa-e32e-4899-a95f-07508f0f9eb4");
		System.out.println("Test me with Swagger:");
		System.out.println("http://localhost:8080/swagger-ui.html");
	}

}
