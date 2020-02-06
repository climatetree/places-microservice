package com.climatetree.places.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.climatetree.places.dao.PlacesRepository;
import com.climatetree.places.dto.PlaceDTO;
import com.climatetree.places.model.EcoName;
import com.climatetree.places.model.PlaceInfo;
import com.climatetree.places.model.Type;
import com.climatetree.places.model.WwfMhtnam;
import com.climatetree.places.model.WwfRealm2;

@RunWith(MockitoJUnitRunner.class)
class PlacesServiceTest {
	
	@InjectMocks
	PlacesService service;
	
	@Mock
    private PlacesRepository repo;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	final void testGetSimilarPlaces() {
		// Create a PlaceInfo object
		Type type = new Type(1, "type", new HashSet<PlaceInfo>());
		EcoName ecoName = new EcoName(2, "ecoName", new HashSet<PlaceInfo>());
		WwfMhtnam wwfmhtnam = new WwfMhtnam(3, "wwfmhtnam", new HashSet<PlaceInfo>());
		WwfRealm2 wwfrealm2 = new WwfRealm2(4, "wwfrealm2", new HashSet<PlaceInfo>());
		PlaceInfo repoParam = new PlaceInfo(0, type, ecoName, wwfmhtnam, wwfrealm2, 1.0, 2.0, 3.0, 4.0, "hasc1", 5.0, 6.0);
		
		// Add the object to an ArrayList
		List<PlaceInfo> our_list = new ArrayList<>();
		our_list.add(repoParam);
		
		// When we call getSimilarPlaces on our repo, return the above list we created
		when(repo.getSimilarPlaces(anyDouble(), anyDouble(), anyDouble(), anyDouble())).thenReturn(our_list);
		
		// call the placesService.getSimilarPlaces function
		PlaceDTO param = new PlaceDTO(0, "", "", 1.0, 2.0, 3.0, 4.0);
		List<PlaceDTO> places = service.getSimilarPlaces(param);
		
		// Assert that our function returned the right information
		assertThat(places).hasSize(1);
	}

}
