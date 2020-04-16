package com.climatetree.places.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.climatetree.places.dao.NameRepository;

@Service
public class NamesService {

	@Autowired
	NameRepository namesRepo;

	@Cacheable(value="places")
	public String getPlacesBySearchTerm(String name) {
		return namesRepo.getPlacesBySearchTerm(name.toUpperCase());
	}

}
