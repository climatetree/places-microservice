package com.climatetree.places.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.climatetree.places.model.Name;

@Repository
public interface NameRepository extends CrudRepository<Name, Integer> {

	@Query(value = "SELECT public.\"getPlacesBySearchTerm\"(\n" +
			"\t:upperName\n" +
			")", nativeQuery = true)
	public String getPlacesBySearchTerm(@Param("upperName") String upperName);

}
