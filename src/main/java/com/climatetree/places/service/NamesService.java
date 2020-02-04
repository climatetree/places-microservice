package com.climatetree.places.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.climatetree.places.dao.NamesRepository;
import com.climatetree.places.dto.PlaceDTO;

@Service
public class NamesService {

	@Autowired
	NamesRepository namesRepo;

	public Set<PlaceDTO> getNamesLike(String name) {
		namesRepo.getNamesLike(name.toUpperCase());
		return null;
	}

}
