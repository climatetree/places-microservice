
package com.climatetree.places.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
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
		Set<PlaceDTO> places = new HashSet<>();
		PlaceDTO dto1 = new PlaceDTO(1, "Manchester", null, 220002002, 23123.22, 2131.323, 122.0, 98.33, 34.3);
		PlaceDTO dto2 = new PlaceDTO(2, "Manila", null, 220002002, 23123.22, 2131.323, 122.0, 98.33, 34.3);

		places.add(dto1);
		places.add(dto2);

		when(nameService.getPlacesByName(any(String.class))).thenReturn(places);

		List<PlaceDTO> placesList = new ArrayList<>(places);
		mvc.perform(get("/names/Man").contentType(APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2))).andExpect(jsonPath("$[0].name", is(placesList.get(0).getName())))
				.andExpect(jsonPath("$[1].name", is(placesList.get(1).getName())));
	}

	@Test
	public void getSimilarPlacesTest() throws Exception {
		List<PlaceDTO> places = new ArrayList<>();
		PlaceDTO dto1 = new PlaceDTO(1, "Manchester", null, 1, 2, 3, 4, 5, 6);
		PlaceDTO dto2 = new PlaceDTO(2, "Boston", null, 1.50, 2, 3, 5.00, 5, 6);

		places.add(dto1);
		places.add(dto2);

		when(placeService.getSimilarPlaces(any(PlaceDTO.class))).thenReturn(places);

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String body = ow.writeValueAsString(dto1);

		List<PlaceDTO> placesList = new ArrayList<>(places);
		mvc.perform(get("/places/1/similar").contentType(APPLICATION_JSON).content(body)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].placeId", is(placesList.get(0).getPlaceId())))
				.andExpect(jsonPath("$[1].placeId", is(placesList.get(1).getPlaceId())));
	}
}
