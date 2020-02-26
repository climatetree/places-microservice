package com.climatetree.places.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.climatetree.places.dto.PlaceDTO;
import com.climatetree.places.dao.PlaceRepository;
import com.climatetree.places.model.PlaceInfo;
import com.climatetree.places.utils.Mapper;

@Service
public class PlacesService {

	@Autowired
	PlaceRepository placesRepo;

	private final int defaultStart = 95;
	private final int defaultEnd = 150;


	public PlaceInfo findPlaceById(int placeId) {
		Optional<PlaceInfo> placesOp = placesRepo.findById(placeId);
		return placesOp.isPresent() ? placesOp.get() : null;
	}

	public List<PlaceInfo> findAllPlaces() {
		List<PlaceInfo> places = new ArrayList<>();
		placesRepo.findAll().forEach(p -> places.add(p));
		return places;
	}

	/**
	 * Returns places that adhere to all of the following constraints when compared
	 * to the given place: 1. Between percentStart and percentEnd of the given place's population 2.
	 * Is the same type (nation, state, county, or urban extent) as the given place.
	 * 
	 * @param placeId the placeId of a Place
	 * @param percentStart the starting value for the population range percentage (95% should given as
	 *                      95)
	 * @param percentEnd the ending value for the population range percentage (150% should be given as
	 *                   150)
	 * @return a list of PlaceDTO objects that are "similar" to the given PlaceDTO
	 */
	public String getSimilarPlaces(int placeId, Integer percentStart, Integer percentEnd) {
		Optional<PlaceInfo> placeOpt = placesRepo.findById(placeId);

		int start = (percentStart != null) ? percentStart : defaultStart;
		int end = (percentEnd != null) ? percentEnd : defaultEnd;

		if (placeOpt.isPresent()) {
			PlaceInfo place = placeOpt.get();
			double popStart = place.getPopulation() * ((double) start / 100);
			double popEnd = place.getPopulation() * ((double) end / 100);
			int typeId = place.getType().getTypeId();

			return this.placesRepo.getSimilarPlaces(popStart, popEnd, typeId);
		}
		return "";
	}

}
