package com.climatetree.places.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.climatetree.places.dao.PlaceRepository;
import com.climatetree.places.model.EcoName;
import com.climatetree.places.model.PlaceInfo;
import com.climatetree.places.model.Type;
import com.climatetree.places.model.WwfMhtnam;
import com.climatetree.places.model.WwfRealm2;

@RunWith(MockitoJUnitRunner.class)
public class PlacesServiceTest {
	
	@InjectMocks
	private PlacesService service;

	private String json_object;
	private PlaceInfo repoParam;

	@Mock
	private PlaceRepository repo;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		// Create a PlaceInfo object
		Type type = new Type(1, "type", new HashSet<PlaceInfo>());
		EcoName ecoName = new EcoName(2, "ecoName", new HashSet<PlaceInfo>());
		WwfMhtnam wwfmhtnam = new WwfMhtnam(3, "wwfmhtnam", new HashSet<PlaceInfo>());
		WwfRealm2 wwfrealm2 = new WwfRealm2(4, "wwfrealm2", new HashSet<PlaceInfo>());
		repoParam = new PlaceInfo(0, type, ecoName, wwfmhtnam, wwfrealm2, 1.0, 2.0, 3.0, 4.0, "hasc1", 5.0, 6.0);

		// Add the object to an ArrayList
		json_object = "Json Object";

		// When we call findById on our repo
		when(repo.findById(anyInt())).thenReturn(Optional.of(repoParam));
		}

	@Test
	public void getSimilarPlacesTest1() {
		// When we call getSimilarPlaces on our repo
		when(repo.getSimilarPlaces(anyDouble(), anyDouble(), anyInt(), anyDouble(), anyDouble(),
						anyDouble(), anyDouble(), anyDouble(), anyDouble())).thenReturn(json_object);

		String places = service.getSimilarPlaces(0, 95, 150,
						null, null, null, null, null, null);

		// Assert that our function returned the right information
		assertThat(places).isEqualTo("Json Object");
	}

	@Test
	public void getSimilarPlacesTest2() {
		// When we call getSimilarPlaces on our repo
		when(repo.findById(anyInt())).thenReturn(Optional.empty());

		String places = service.getSimilarPlaces(0, 95, 150,
						null, null, null, null, null, null);

		// Assert that our function returned the right information
		assertThat(places).isEqualTo("");
	}

}
