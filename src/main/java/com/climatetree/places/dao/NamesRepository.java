package com.climatetree.places.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.climatetree.places.model.Name;

@Repository
public interface NamesRepository extends CrudRepository<NamesRepository, Integer> {
	
	@Query("Select name from Name name where upper(name.placeId) like %:upperName%")
	public List<Name> getNamesLike(@Param("upperName") String upperName);

}
