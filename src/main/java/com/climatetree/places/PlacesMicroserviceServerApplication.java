package com.climatetree.places;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PlacesMicroserviceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlacesMicroserviceServerApplication.class, args);
	}

}
