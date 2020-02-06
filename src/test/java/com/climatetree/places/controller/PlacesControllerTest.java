package com.climatetree.places.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

import com.climatetree.places.dao.PlacesRepository;
import com.climatetree.places.model.EcoName;
import com.climatetree.places.model.PlaceInfo;
import com.climatetree.places.model.Type;
import com.climatetree.places.model.WwfMhtnam;
import com.climatetree.places.model.WwfRealm2;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@DataJpaTest
public class PlacesControllerTest {
	
	@Autowired private DataSource dataSource;
	@Autowired private JdbcTemplate jdbcTemplate;
	@Autowired private EntityManager entityManager;
	@Autowired private PlacesRepository placesRepository;
	
	@Test
	void injectedComponentsAreNotNullTest(){
	  assertThat(dataSource).isNotNull();
	  assertThat(jdbcTemplate).isNotNull();
	  assertThat(entityManager).isNotNull();
	  assertThat(placesRepository).isNotNull();
	}
	  	  
	@Test
	@Sql(scripts={"classpath:createPlace.sql"})
	void placesRepositoryTest() {
		List<PlaceInfo> actual = placesRepository.getSimilarPlaces(.95, 1.25, 3.8, 5.0);

		boolean[] success = {false, false, false, false, false};
		
		for (int i = 0; i < actual.size(); i++) {
			int id = actual.get(i).getPlaceId();
			success[id] = true;
		}
		
		boolean total_success = true;
		for(boolean b : success) if(!b) total_success = false;
		
		assertThat(actual).isNotNull();
		assertThat(total_success).isTrue();
		assertThat(actual).hasSize(5);
		
	}
	  
 
}