
package com.climatetree.places.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.climatetree.places.dto.PlaceDTO;
import com.climatetree.places.service.NamesService;
import com.climatetree.places.service.PlacesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@RunWith(SpringRunner.class)
@WebMvcTest(PlacesController.class)
public class PlacesControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private PlacesService placeService;

	@MockBean
	private NamesService nameService;

	@Test
	public void getPlacesByName() throws Exception {
		String geoJsonString = "Test Dummy Geo Json String";

		when(nameService.getPlacesBySearchTerm(any(String.class))).thenReturn(geoJsonString);

		mvc.perform(get("/api/places/v1/Man").contentType(APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", is(geoJsonString)));
	}

	@Test
	public void getSimilarPlacesTest() throws Exception {
		String geoJsonString = "Test Dummy Geo Json String";

		when(placeService.getSimilarPlacesDefault(anyInt())).thenReturn(geoJsonString);

		mvc.perform(get("/api/places/v1/1/similar")
						.contentType(APPLICATION_JSON)).andExpect(status().isOk())
						.andExpect(jsonPath("$", is(geoJsonString)));
	}

	@Test
	public void getSimilarPlacesTest2() throws Exception {
		String geoJsonString = "Test Dummy Geo Json String";

		when(placeService.getSimilarPlacesAdvanced(anyInt(), anyInt(), anyInt(), anyInt(), anyInt(), anyInt(),
						anyInt(), anyInt(), anyInt())).thenReturn(geoJsonString);

		mvc.perform(get("/api/places/v1/1/similar/advanced?populationStart=90&populationEnd=100&carbonStart=88&carbonEnd=112&" +
						"perCapCarbonStart=86&perCapCarbonEnd=114&popDensityStart=84&popDensityEnd=116")
						.contentType(APPLICATION_JSON)).andExpect(status().isOk())
						.andExpect(jsonPath("$", is(geoJsonString)));
	}

	@Test
	public void getSimilarPlacesTest3() throws Exception {
		String geoJsonString = "Test Dummy Geo Json String";

		when(placeService.getSimilarPlacesAdvanced(anyInt(), isNull(), isNull(), isNull(), isNull(), isNull(),
						isNull(), isNull(), isNull())).thenReturn(geoJsonString);

		mvc.perform(get("/api/places/v1/1/similar/advanced")
						.contentType(APPLICATION_JSON)).andExpect(status().isOk())
						.andExpect(jsonPath("$", is(geoJsonString)));
	}

	@Test
  public void getNearestPlaceTest() throws Exception {
    String geoJsonString = "Test Dummy Geo Json String";

    when(placeService.getNearbyPlace(anyDouble(),anyDouble())).thenReturn(geoJsonString);

    mvc.perform(get("/api/places/v1/nearest?latitude=47&longitude=-122").contentType(APPLICATION_JSON))
        .andExpect(status().isOk()).andExpect(jsonPath("$", is(geoJsonString)));
  }
}
