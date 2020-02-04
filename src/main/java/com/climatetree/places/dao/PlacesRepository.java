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
	
	@Query("Select place from PlaceInfo place WHERE place.population>=:popStart AND place.population<=:popEnd AND place.popdensity>=:popDensityStart AND place.popdensity<=:popDensityEnd")
	public List<PlaceInfo> getSimilarPlaces(@Param("popStart") double popStart, 
											@Param("popEnd") double popEnd, 
											@Param("popDensityStart") double popDensityStart,
											@Param("popDensityEnd") double popDensityEnd);
}
