package com.climatetree.places.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.climatetree.places.model.PlaceInfo;

@Repository
public interface PlacesRepository extends CrudRepository<PlaceInfo, Integer> {
}
