package com.climatetree.places.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.climatetree.places.model.PlaceInfo;

@Repository
public interface PlaceRepository extends CrudRepository<PlaceInfo, Integer> {
	
	/**
	 * Queries the database for PlaceInfo entries that are within the following range:
	 *  - Population is greater than popStart
	 *  - Population is less than popEnd
	 * 
	 * @param popStart start of the population range
	 * @param popEnd end of the population range
   * @param typeId the type id ( 1 = state, 2 = nation , 3 = county, 4 = urbanextent)
	 * @return a list of PlaceInfo objects
	 */
	@Query(value = "SELECT public.\"getSimilarPlaces\"(\n" +
			"\t:popStart, \n" +
			"\t:popEnd, \n" +
			"\t:typeId\n" +
			")", nativeQuery = true)
	public String getSimilarPlaces(@Param("popStart") double popStart,
											@Param("popEnd") double popEnd,@Param("typeId") int typeId);

  /**
   * Queries the database and finds the nearest place to the given latitude and longitude
   * by elucidaian distance.
   * @param latitude the latitude to search near
   * @param longitude the longitude to search near
   * @return geoJSON string representing the found place
   */
	@Query(value = "SELECT public.\"getNearestPlace\"(\n" +
			"\t:longitude, \n" +
			"\t:latitude\n" +
			")", nativeQuery = true)
	String getNearestPlace(@Param("latitude") double latitude, @Param("longitude") double longitude);
}
