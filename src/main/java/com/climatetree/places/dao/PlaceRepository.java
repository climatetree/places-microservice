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
	 * Uses a stored database function to query the database and return a geoJson object where each
	 * Place in the list fits the following criteria:
	 *  - TypeId = TypeId
	 *  - popStart <= population <= popEnd
	 *  - carbonStart <= carbon <= carbonEnd
	 *  - perCapCarbStart <= per capita carbon <= perCapCarbEnd
	 *  - popDensityStart <= population density <= popDensityEnd
	 *
	 * @param popStart start of the population range
	 * @param popEnd end of the population range
	 * @param typeId the type id ( 1 = state, 2 = nation , 3 = county, 4 = urbanextent)
	 * @param carbonStart: start of the carbon range
	 * @param carbonEnd: end of the carbon range
	 * @param perCapCarbStart: start of the per capita carbon range
	 * @param perCapCarbEnd: end of the per capita carbon range
	 * @param popDensityStart: start of the population density range
	 * @param popDensityEnd: end of the population density range
	 * @return a geoJson list of places
	 */
	@Query(value = "SELECT public.\"getSimilarPlaces\"(\n" +
					"\t:popStart, \n" +
					"\t:popEnd, \n" +
					"\t:typeId, \n" +
					"\t:carbonStart, \n" +
					"\t:carbonEnd, \n" +
					"\t:perCapCarbStart, \n" +
					"\t:perCapCarbEnd, \n" +
					"\t:popDensityStart, \n" +
					"\t:popDensityEnd\n" +
					");", nativeQuery = true)
	String getSimilarPlaces(@Param("typeId") int typeId,
													@Param("popStart") double popStart, @Param("popEnd") double popEnd,
												  @Param("carbonStart") double carbonStart, @Param("carbonEnd") double carbonEnd,
												  @Param("perCapCarbStart") double perCapCarbStart, @Param("perCapCarbEnd") double perCapCarbEnd,
												  @Param("popDensityStart") double popDensityStart, @Param("popDensityEnd") double popDensityEnd);

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
