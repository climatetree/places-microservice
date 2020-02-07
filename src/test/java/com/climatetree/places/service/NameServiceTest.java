package com.climatetree.places.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.climatetree.places.dao.NameRepository;
import com.climatetree.places.dto.PlaceDTO;
import com.climatetree.places.model.Name;
import com.climatetree.places.model.PlaceInfo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

@RunWith(MockitoJUnitRunner.class)
public class NameServiceTest {

	@InjectMocks
	NamesService service;

	@Mock
	NameRepository dao;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getPlacesNyNameTest() {
		Set<PlaceInfo> places1 = new HashSet<>();
		PlaceInfo p1 = new PlaceInfo(1, null, null, null, null, null, 10.0, 11.0, 12.0, 13.0, "h1", 22.0, 22.5);
		PlaceInfo p2 = new PlaceInfo(2, null, null, null, null, null, 14.0, 16.0, 11.0, 33.0, "h2", 26.0, 27.5);
		places1.add(p1);
		places1.add(p2);

		Set<PlaceInfo> places2 = new HashSet<>();
		PlaceInfo p3 = new PlaceInfo(3, null, null, null, null, null, 17.0, 13.0, 12.0, 31.0, "h3", 21.0, 23.6);
		places2.add(p3);

		List<Name> names = new ArrayList<>();
		Name n1 = new Name(1, "Manchester", places1);
		Name n2 = new Name(1, "Manila", places2);

		names.add(n1);
		names.add(n2);

		when(dao.getPlacesByName(any(String.class))).thenReturn(names);

		Set<PlaceDTO> places = service.getPlacesByName("Man");

		assertEquals(3, places.size());
		verify(dao, times(1)).getPlacesByName(any(String.class));
	}

}
