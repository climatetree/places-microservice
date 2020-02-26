package com.climatetree.places.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.climatetree.places.model.PlaceInfo;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

@DataJpaTest
public class PlacesRepositoryTest {

	@Autowired private PlaceRepository repository;

	@Test
	void saveAndFindByIdTest() {
		Set<PlaceInfo> places1 = new HashSet<>();
		PlaceInfo p1 = new PlaceInfo(1, null, null, null, null, null, 10.0, 11.0, 12.0, 13.0, "h1", 22.0, 22.5);
		PlaceInfo p2 = new PlaceInfo(2, null, null, null, null, null, 14.0, 16.0, 11.0, 33.0, "h2", 26.0, 27.5);
		places1.add(p1);
		places1.add(p2);

		repository.save(p1);
		PlaceInfo place = repository.findById(p1.getPlaceId()).isPresent() ? repository.findById(p1.getPlaceId()).get() : null;

		assertNotNull(place);
		assertEquals(place.getPopulation(), p1.getPopulation(), .001);
	}
}