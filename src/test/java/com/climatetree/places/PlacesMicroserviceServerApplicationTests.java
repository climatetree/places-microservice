package com.climatetree.places;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.climatetree.places.controller.PlacesController;
import com.climatetree.places.dao.PlacesRepository;
import com.climatetree.places.service.PlacesService;

@SpringBootTest
@AutoConfigureMockMvc
class PlacesMicroserviceServerApplicationTests {
	
	@Autowired
	MockMvc mockMvc;
	
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
