package com.climatetree.places.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

import com.climatetree.places.dao.PlacesRepository;
import com.climatetree.places.dto.PlaceDTO;
import com.climatetree.places.model.EcoName;
import com.climatetree.places.model.PlaceInfo;
import com.climatetree.places.model.Type;
import com.climatetree.places.model.WwfMhtnam;
import com.climatetree.places.model.WwfRealm2;
import com.climatetree.places.service.PlacesService;

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
	@Sql("createPlace.sql")
	void placesRepositoryTest() {
		PlacesService placesService;
		List<PlaceInfo> actual = placesRepository.getSimilarPlaces(.95, 1.25, 3.8, 5.0);
		Type type = new Type(1, "type", new HashSet<PlaceInfo>());
		EcoName ecoName = new EcoName(2, "ecoName", new HashSet<PlaceInfo>());
		WwfMhtnam wwfmhtnam = new WwfMhtnam(3, "wwfmhtnam", new HashSet<PlaceInfo>());
		WwfRealm2 wwfrealm2 = new WwfRealm2(4, "wwfrealm2", new HashSet<PlaceInfo>());
		PlaceInfo repoParam = new PlaceInfo(0, type, ecoName, wwfmhtnam, wwfrealm2, 1.0, 2.0, 3.0, 4.0, "hasc1", 5.0, 6.0);
		PlaceInfo place1 = new PlaceInfo(1, type, ecoName, wwfmhtnam, wwfrealm2, .95, 2.0, 3.0, 4.0, "hasc1", 5.0, 6.0);
		PlaceInfo place2 = new PlaceInfo(2, type, ecoName, wwfmhtnam, wwfrealm2, 1.25, 2.0, 3.0, 4.0, "hasc1", 5.0, 6.0);
		PlaceInfo place3 = new PlaceInfo(3, type, ecoName, wwfmhtnam, wwfrealm2, 1.0, 2.0, 3.0, 3.8, "hasc1", 5.0, 6.0);
		PlaceInfo place4 = new PlaceInfo(4, type, ecoName, wwfmhtnam, wwfrealm2, 1.0, 2.0, 3.0, 5.01, "hasc1", 5.0, 6.0);
		List<PlaceInfo> expected = new ArrayList<PlaceInfo>(Arrays.asList(repoParam, place1, place2, place3, place4));
	    
		assertThat(actual.equals(expected));
	}
	  
//	  @Test
//	  @Sql("createPlace.sql")
//	  void placesServiceTest() {
//		  
//		PlaceDTO param = new PlaceDTO(0, "", "", 1.0, 2.0, 3.0, 4.0);
//    	PlaceDTO place1 = new PlaceDTO(1, "", "", .95, 2.0, 3.0, 4.0);
//		PlaceDTO place2 = new PlaceDTO(2, "", "", 1.25, 2.0, 3.0, 4.0);
//		PlaceDTO place3 = new PlaceDTO(3, "", "", 1.0, 2.0, 3.0, 3.8);
//		PlaceDTO place4 = new PlaceDTO(4, "", "", 1.0, 2.0, 3.0, 5.01);
//	    List<PlaceDTO> expected = new ArrayList<PlaceDTO>(Arrays.asList(param, place1, place2, place3, place4));
//	    
//	    List<PlaceDTO> actual = placesService.getSimilarPlaces(param);
//	    
//	    assertThat(actual.equals(expected));
//		  
//		  
//	  }

 
}