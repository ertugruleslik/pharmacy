package com.pharmacy.pharmacyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PharmacyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmacyApiApplication.class, args);
	}

}
