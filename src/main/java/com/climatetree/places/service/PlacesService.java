package com.climatetree.places.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.climatetree.places.dao.PlaceRepository;
import com.climatetree.places.model.PlaceInfo;

@Service
public class PlacesService {

	@Autowired
	PlaceRepository placesRepo;

	public PlaceInfo findPlaceById(int placeId) {
		Optional<PlaceInfo> placesOp =  placesRepo.findById(placeId);
		return placesOp.isPresent() ? placesOp.get(): null;
	}
	
	public List<PlaceInfo> findAllPlaces() {
		List<PlaceInfo> places = new ArrayList<>();
		placesRepo.findAll().forEach(p -> places.add(p));
		return places;
	}

}
