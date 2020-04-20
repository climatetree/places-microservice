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

	/**
	 * Find a single Place from the database with the provided placeId.
	 *
	 * @param placeId place Id
	 * @return PlaceInfo object
	 */
	public PlaceInfo findPlaceById(int placeId) {
		Optional<PlaceInfo> placesOp = placesRepo.findById(placeId);
		return placesOp.isPresent() ? placesOp.get() : null;
	}

	/**
	 * Find all Place from the database.
	 *
	 * @return List of PlaceInfo objects
	 */
	public List<PlaceInfo> findAllPlaces() {
		List<PlaceInfo> places = new ArrayList<>();
		placesRepo.findAll().forEach(p -> places.add(p));
		return places;
	}

	/**
	 * Returns places that adhere to all of the following constraints when compared
	 * to the given place: 1. Between 95% and 150% of the given place's population 2.
	 * Is the same type (nation, state, county, or urban extent) as the given place.
	 * 
	 * @param placeId the placeId of a Place
	 * @return a list of PlaceDTO objects that are "similar" to the given PlaceDTO
	 */
	public String getSimilarPlacesDefault(int placeId) {
    Optional<PlaceInfo> placeOpt = placesRepo.findById(placeId);

    if (placeOpt.isPresent()) {
      PlaceInfo place = placeOpt.get();
      double popStart = place.getPopulation() * ((double) defaultStart / 100);
      double popEnd = place.getPopulation() * ((double) defaultEnd / 100);
      int typeId = place.getType().getTypeId();

      return this.placesRepo.getSimilarPlaces(typeId, popStart, popEnd, -1, -1,
							-1, -1, -1, -1);
    }
    return StringUtils.EMPTY;
  }

	/**
	 * Returns places that adhere to all of the following constraints when compared
	 * to the given place:
	 * 		1. Between percentStart and percentEnd of the given place's population
	 * 		2. Between carbonStart and carbonEnd of the given place's carbon
	 * 		3. Between perCapCarbonStart and perCapCarbonEnd of the given places per capita carbon.
	 * 		4. Between popDensityStart and popDensityEnd of the given places population density.
	 * 		5. Is the same type (nation, state, county, or urban extent) as the given place.
	 *
	 * @param placeId the placeId of a Place
	 * @return a GeoJson string listing all matching places
	 */
	public String getSimilarPlacesAdvanced(int placeId, Integer popStart, Integer popEnd,
																 Integer carbonStart, Integer carbonEnd, Integer perCapCarbonStart,
																 Integer perCapCarbonEnd, Integer popDensityStart,
																 Integer popDensityEnd) {
		Optional<PlaceInfo> placeOpt = placesRepo.findById(placeId);

		if (placeOpt.isPresent()) {
			PlaceInfo place = placeOpt.get();
			double pStart = (popStart != null) ? place.getPopulation() * ( (double) popStart/ 100) : -1;
			double pEnd = (popEnd != null) ? place.getPopulation() * ( (double) popEnd/ 100) : -1;
			double cStart = (carbonStart != null) ? place.getCarbon() * ( (double) carbonStart/ 100) : -1;
			double cEnd = (carbonEnd != null) ? place.getCarbon() * ((double) carbonEnd / 100) : -1;
			double pcStart = (perCapCarbonStart != null) ? place.getPercapcarb() * ((double) perCapCarbonStart / 100) : -1;
			double pcEnd = (perCapCarbonEnd != null) ? place.getPercapcarb() * ((double) perCapCarbonEnd / 100) : -1;
			double pdStart = (popDensityStart != null) ? place.getPopdensity() * ((double) popDensityStart / 100) : -1;
			double pdEnd = (popDensityEnd != null) ? place.getPopdensity() * ((double) popDensityEnd / 100) : -1;
			int typeId = place.getType().getTypeId();

			return this.placesRepo.getSimilarPlaces(typeId, pStart, pEnd, cStart, cEnd, pcStart, pcEnd, pdStart, pdEnd);
		}
		return StringUtils.EMPTY;
	}

  /**
   * Returns the nearest place to the given latitude and longitude by elucidaian distance
   * @param latitude the latitude to search near, range [-90,90]
   * @param longitude the longitude to search near, range [-180,80]
   * @return geoJSON string representing the found place
   */
	public String getNearbyPlace(double latitude, double longitude) {
	  return placesRepo.getNearestPlace(latitude, longitude);
  }

}
