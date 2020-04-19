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

/**
 * Class that defines all of the API endpoints for the Places backend microservice.
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://climatetree-api-gateway.azurewebsites.net")
public class PlacesController {

	@Autowired
	PlacesService placesService;

	@Autowired
	NamesService namesService;

	/**
	 * This endpoint returns a list of places as a GeoJson object that are similar to the place
	 * with the given placeId. A place is similar if it is within 95%-150% population of the provided
	 * place.
	 *
	 * @param placeId integer
	 * @return GeoJson list of places
	 */
	@GetMapping("/v1/places/{placeId}/similar")
	public String getSimilarPlaces(@PathVariable("placeId") int placeId) {
		return placesService.getSimilarPlacesDefault(placeId);
	}

	/**
	 * This endpoint returns a list of places as a GeoJson object that are similar to the place
	 * with the given placeId. This is an advanced filter for similar searching which means that all
	 * places that are returned are within every range that are provided from the user. All ranges
	 * are optional.
	 *
	 * @param placeId int
	 * @param populationStart low value of population range
	 * @param populationEnd high value of the population range
	 * @param carbonStart low value of carbon range
	 * @param carbonEnd high value of carbon range
	 * @param perCapCarbonStart low value of per capita carbon range
	 * @param perCapCarbonEnd high value of per capita carbon range
	 * @param popDensityStart low value of population density range
	 * @param popDensityEnd hig value of population density range
	 * @return GeoJson list of places
	 */
  @GetMapping("/v1/places/{placeId}/similar/advanced")
  public String getSimilarPlaces(@PathVariable("placeId") int placeId,
                                 @RequestParam(required = false) Integer populationStart,
                                 @RequestParam(required = false) Integer populationEnd,
                                 @RequestParam(required = false) Integer carbonStart,
                                 @RequestParam(required = false) Integer carbonEnd,
                                 @RequestParam(required = false) Integer perCapCarbonStart,
                                 @RequestParam(required = false) Integer perCapCarbonEnd,
                                 @RequestParam(required = false) Integer popDensityStart,
                                 @RequestParam(required = false) Integer popDensityEnd) {
    return placesService.getSimilarPlacesAdvanced(placeId, populationStart, populationEnd, carbonStart,
            carbonEnd, perCapCarbonStart, perCapCarbonEnd, popDensityStart, popDensityEnd);
  }

	/**
	 * THIS IS THE ONLY API THAT IS CURRENTLY BEING USED ON THE FRONT END.
	 *
	 * This endpoint returns a list of places that contain the provided name. For example if the given
	 * name is 'Man', any place in the database that has a name that contains "man", will be returned.
	 * @param name serach term
	 * @return GeoJson list of places
	 */
	@GetMapping("/v1/places/{name}")
	public String getPlacesByName(@PathVariable("name") String name) {
		return namesService.getPlacesBySearchTerm(name);
	}

	/**
	 * This endpoint returns a single place that is closest (in geographical location) to the given
	 * latitude/longitude point.
	 *
	 * @param latitude latitude in degrees
	 * @param longitude longitude in degrees
	 * @return GeoJson object containing 1 place
	 */
	@GetMapping("/v1/places/nearest")
  public String getNearestPlace(@RequestParam double latitude, @RequestParam double longitude){
	  return placesService.getNearbyPlace(latitude, longitude);
  }
	
}
