package com.climatetree.places.controller;


import java.util.List;

import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.climatetree.places.dto.PlaceDTO;
import com.climatetree.places.model.PlaceInfo;
import com.climatetree.places.service.NamesService;
import com.climatetree.places.service.PlacesService;

@RestController
@CrossOrigin(origins = "*")
public class PlacesController {

	@Autowired
	PlacesService placesService;

	@Autowired
	NamesService namesService;

	@GetMapping("/places/{placeId}")
	public PlaceInfo getAllPlaces(@PathVariable("placeId") int placeId) {
		return placesService.findPlaceById(placeId);
	}
	
	@GetMapping("/places/{placeId}/similar")
	public List<PlaceDTO> getSimilarPlaces(@PathVariable("placeId") int placeId, @RequestBody PlaceDTO place) {
		return placesService.getSimilarPlaces(place);
	}

	@GetMapping("/names/{name}")
	public Set<PlaceDTO> getPlacesByName(@PathVariable("name") String name) {
		return namesService.getPlacesByName(name);
	}

}
