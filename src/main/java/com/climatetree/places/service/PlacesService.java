package com.climatetree.places.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.climatetree.places.dao.PlacesRepository;
import com.climatetree.places.model.PlaceInfo;

@Service
public class PlacesService {

	@Autowired
	PlacesRepository placesRepo;

	public PlaceInfo findPlaceById(int placeId) {
		return placesRepo.findById(placeId).get();
	}
	
	public List<PlaceInfo> findAllPlaces() {
		List<PlaceInfo> places = new ArrayList<>();
		placesRepo.findAll().forEach(p -> places.add(p));
		return places;
	}

}
