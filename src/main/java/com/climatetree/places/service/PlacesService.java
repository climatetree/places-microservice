package com.climatetree.places.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.climatetree.places.dao.PlacesRepository;
import com.climatetree.places.dto.PlaceDTO;
import com.climatetree.places.model.PlaceInfo;

@Service
public class PlacesService {

	@Autowired
	PlacesRepository placesRepo;

	public PlaceInfo findPlaceById(int placeId) {
		Optional<PlaceInfo> placesOp =  placesRepo.findById(placeId);
		return placesOp.isPresent() ? placesOp.get(): null;
	}
	
	public List<PlaceInfo> findAllPlaces() {
		List<PlaceInfo> places = new ArrayList<>();
		placesRepo.findAll().forEach(p -> places.add(p));
		return places;
	}
	
	/**
	 * Returns places that adhere to all of the following constraints when compared to the given place:
	 *  1. Between 95% to 150% of the given place's population
	 *  2. Between 95% to 150% of the given place's population density
	 *  
	 * @param place a PlaceDTO object
	 * @return a list of PlaceDTO objects that are "similar" to the given PlaceDTO
	 */
	public List<PlaceDTO> getSimilarPlaces(PlaceDTO place) {
		List<PlaceDTO> places = new ArrayList<>();
		double pop_start = place.getPopulation() * .95;
		double pop_end = place.getPopulation() * 1.50;
		double popDensity_start = place.getPopdensity() * .95;
		double popDensity_end = place.getPopdensity() * 1.50;
		
		this.placesRepo.getSimilarPlaces(pop_start, pop_end, popDensity_start, popDensity_end)
		.forEach(p -> places.add(p.convertToPlaceDTO()));
		
		return places;
	}

}
