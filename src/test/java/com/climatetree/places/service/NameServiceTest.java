package com.climatetree.places.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.climatetree.places.dao.NameRepository;

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
		String geoJsonString = "Test Dummy Geo Json String";

		when(dao.getPlacesBySearchTerm(any(String.class))).thenReturn(geoJsonString);

		String resultGeoJsonString = service.getPlacesBySearchTerm("Man");

		assertEquals(geoJsonString, resultGeoJsonString);

		verify(dao, times(1)).getPlacesBySearchTerm(any(String.class));
	}

}
