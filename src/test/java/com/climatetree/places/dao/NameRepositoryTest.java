package com.climatetree.places.dao;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.climatetree.places.model.Name;
import com.climatetree.places.model.PlaceInfo;;

@RunWith(SpringRunner.class)
@DataJpaTest
@Sql(scripts = { "/data-h2.sql" })
public class NameRepositoryTest {

	@Autowired
	private NameRepository repository;

	@Test
	public void saveAndFindByIdTest() {

		Set<PlaceInfo> places1 = new HashSet<>();
		PlaceInfo p1 = new PlaceInfo(1, null, null, null, null, null, 10.0, 11.0, 12.0, 13.0, "h1", 22.0, 22.5);
		PlaceInfo p2 = new PlaceInfo(2, null, null, null, null, null, 14.0, 16.0, 11.0, 33.0, "h2", 26.0, 27.5);
		places1.add(p1);
		places1.add(p2);

		Name n1 = new Name(1, "Manchester", places1);

		repository.save(n1);
		Name name = repository.findById(n1.getNameId()).isPresent() ? repository.findById(n1.getNameId()).get() : null;

		assertNotNull(name);
		assertEquals(name.getName(), n1.getName());
	}

//	@Test
//	public void getPlacesByNameTest() {
//
//		List<Name> names = new ArrayList<>();
//		repository.getPlacesByName("MAN").forEach(names::add);
//
//		assertThat(names, hasSize(2));
//	}

}