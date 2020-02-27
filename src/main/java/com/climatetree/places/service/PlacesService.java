package com.climatetree.places.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.climatetree.places.dao.PlaceRepository;
import com.climatetree.places.model.PlaceInfo;

@Service
@PropertySource("classpath:constants.properties")
public class PlacesService {

	@Autowired
	PlaceRepository placesRepo;

	@Value("${default_population_start}")
	private int defaultStart;

  @Value("${default_population_end}")
	private int defaultEnd;


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
		return StringUtils.EMPTY;
	}

}
