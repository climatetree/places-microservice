package com.climatetree.places.controller;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
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
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(PlacesController.class)
public class PlacesControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private PlacesController controller;

	@Test
	public void getPlacesByName() throws Exception {
		Set<PlaceDTO> places = new HashSet<>();
		PlaceDTO dto1 = new PlaceDTO(1, "Manchester", null, 220002002, 23123.22, 2131.323, 122.0, 98.33, 34.3);
		PlaceDTO dto2 = new PlaceDTO(2, "Manila", null, 220002002, 23123.22, 2131.323, 122.0, 98.33, 34.3);

		places.add(dto1);
		places.add(dto2);

		given(controller.getPlacesByName(any(String.class))).willReturn(places);

		List<PlaceDTO> placesList = new ArrayList<>(places);
		mvc.perform(get("/names/Man").contentType(APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].name", is(placesList.get(0).getName())))
				.andExpect(jsonPath("$[1].name", is(placesList.get(1).getName())));
	}

}
