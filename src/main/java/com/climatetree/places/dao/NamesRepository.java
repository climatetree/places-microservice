package com.climatetree.places.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.climatetree.places.model.Name;

@Repository
public interface NamesRepository extends CrudRepository<Name, Integer> {
	
	@Query("Select name from Name name where upper(name.name) like %:upperName%")
	public List<Name> getPlacesByName(@Param("upperName") String upperName);

}
