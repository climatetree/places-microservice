package com.climatetree.places.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.climatetree.places.model.PlaceInfo;

@Repository
public interface PlacesRepository extends CrudRepository<PlaceInfo, Integer> {
	
	@Query("Select place from PlaceInfo place where place.placeId=:id")
	public List<PlaceInfo> findPlacesById(@Param("id") int id);
	
	/**
	 * Queries the database for PlaceInfo entries that are within the following range:
	 *  - Population is greater than popStart
	 *  - Population is less than popEnd
	 *  - Population density is greater than popDensityStart
	 *  - Population density is less than popDensityEnd
	 * 
	 * @param popStart start of the population range
	 * @param popEnd end of the population range
	 * @param popDensityStart start of the population density range
	 * @param popDensityEnd end of the population density range
	 * @return a list of PlaceInfo objects
	 */
	@Query("Select place from PlaceInfo place WHERE place.population>=:popStart AND place.population<=:popEnd AND place.popdensity>=:popDensityStart AND place.popdensity<=:popDensityEnd")
	public List<PlaceInfo> getSimilarPlaces(@Param("popStart") double popStart, 
											@Param("popEnd") double popEnd, 
											@Param("popDensityStart") double popDensityStart,
											@Param("popDensityEnd") double popDensityEnd);
}
