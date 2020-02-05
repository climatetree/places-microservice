package com.climatetree.places.controller;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

import com.climatetree.places.dao.PlacesRepository;
import com.climatetree.places.dto.PlaceDTO;
import com.climatetree.places.service.PlacesService;

@DataJpaTest
public class PlacesServiceTest {

	@Autowired private DataSource dataSource;
	@Autowired private JdbcTemplate jdbcTemplate;
	@Autowired private EntityManager entityManager;
	@Autowired private PlacesRepository placesRepo;
	
	@Test
	void injectedComponentsAreNotNullTest(){
		assertThat(dataSource).isNotNull();
		assertThat(jdbcTemplate).isNotNull();
		assertThat(entityManager).isNotNull();
	}
	
	
	
	@Test
	@Sql("createPlace.sql")
	void placesServiceTest() {
//		PlacesService placesService = new PlacesService();
//		placesService.setRepo(placesRepo);
//		PlaceDTO param = new PlaceDTO(0, "", "", 1.0, 2.0, 3.0, 4.0);
//		PlaceDTO place1 = new PlaceDTO(1, "", "", .95, 2.0, 3.0, 4.0);
//		PlaceDTO place2 = new PlaceDTO(2, "", "", 1.25, 2.0, 3.0, 4.0);
//		PlaceDTO place3 = new PlaceDTO(3, "", "", 1.0, 2.0, 3.0, 3.8);
//		PlaceDTO place4 = new PlaceDTO(4, "", "", 1.0, 2.0, 3.0, 5.01);
//		List<PlaceDTO> expected = new ArrayList<PlaceDTO>(Arrays.asList(param, place1, place2, place3, place4));
//		List<PlaceDTO> actual = placesService.getSimilarPlaces(param);
//    
//		assertThat(actual.equals(expected));
	  
  }
}
