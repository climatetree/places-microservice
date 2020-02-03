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
	
}
