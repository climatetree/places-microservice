package com.climatetree.places.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.climatetree.places.dao.NameRepository;

@Service
public class NamesService {

	@Autowired
	NameRepository namesRepo;

	/**
	 * Function that takes the provided place, changes it to all uppercase and calls the repository function
	 * to find places that contain the given search term.
	 *
	 * @param name search term
	 * @return GeoJson list of places
	 */
	@Cacheable(value="places")
	public String getPlacesBySearchTerm(String name) {
		return namesRepo.getPlacesBySearchTerm(name.toUpperCase());
	}

}
