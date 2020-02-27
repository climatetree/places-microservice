package com.climatetree.places.controller;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.climatetree.places.dto.PlaceDTO;
import com.climatetree.places.service.NamesService;
import com.climatetree.places.service.PlacesService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class PlacesController {

	@Autowired
	PlacesService placesService;

	@Autowired
	NamesService namesService;

	@GetMapping("/places/{placeId}/similar")
	public String getSimilarPlaces(@PathVariable("placeId") int placeId,
																 @RequestParam(required = false) Integer populationStart,
																 @RequestParam(required = false) Integer populationEnd) {
		return placesService.getSimilarPlaces(placeId, populationStart, populationEnd);
	}

	@GetMapping("/places/{name}")
	public String getPlacesByName(@PathVariable("name") String name) {
		return namesService.getPlacesBySearchTerm(name);
	}
	
}
