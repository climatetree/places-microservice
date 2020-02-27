
package com.climatetree.places.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
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

		mvc.perform(get("/api/places/Man").contentType(APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", is(geoJsonString)));
	}

	@Test
	public void getSimilarPlacesTest() throws Exception {
		List<PlaceDTO> places = new ArrayList<>();
		PlaceDTO dto1 = new PlaceDTO(1, "Manchester", null, 1, 2, 3, 4, 5, 6);
		PlaceDTO dto2 = new PlaceDTO(2, "Boston", null, 1.50, 2, 3, 5.00, 5, 6);

		places.add(dto1);
		places.add(dto2);

		when(placeService.getSimilarPlaces(anyInt())).thenReturn(places);

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String body = ow.writeValueAsString(dto1);

		List<PlaceDTO> placesList = new ArrayList<>(places);
		mvc.perform(get("/api/places/1/similar").contentType(APPLICATION_JSON).content(body)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].placeId", is(placesList.get(0).getPlaceId())))
				.andExpect(jsonPath("$[1].placeId", is(placesList.get(1).getPlaceId())));
	}
}
