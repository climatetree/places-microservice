package com.climatetree.places;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.climatetree.places.controller.PlacesController;
import com.climatetree.places.dao.PlacesRepository;
import com.climatetree.places.service.PlacesService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PlacesMicroserviceServerApplicationTests {
	
	@Autowired
	private PlacesRepository repo;
	
	@Autowired
	private PlacesService service;
	
	@Autowired
	private PlacesController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
		assertThat(service).isNotNull();
		assertThat(repo).isNotNull();
	}

}
