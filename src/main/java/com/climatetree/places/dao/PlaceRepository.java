package com.climatetree.places.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.climatetree.places.model.PlaceInfo;

@Repository
public interface PlaceRepository extends CrudRepository<PlaceInfo, Integer> {

	@Query(value = "SELECT public.\"getSimilarPlaces2\"(\n" +
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
	public String getSimilarPlaces(@Param("popStart") double popStart, @Param("popEnd") double popEnd,
																 @Param("typeId") int typeId,
																 @Param("carbonStart") double carbonStart, @Param("carbonEnd") double carbonEnd,
																 @Param("perCapCarbStart") double perCapCarbStart, @Param("perCapCarbEnd") double perCapCarbEnd,
																 @Param("popDensityStart") double popDensityStart, @Param("popDensityEnd") double popDensityEnd);

}
