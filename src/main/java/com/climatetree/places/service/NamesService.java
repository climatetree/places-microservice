package com.climatetree.places.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.climatetree.places.dao.NameRepository;
import com.climatetree.places.dto.PlaceDTO;
import com.climatetree.places.model.Name;
import com.climatetree.places.model.PlaceInfo;

@Service
public class NamesService {

	@Autowired
	NameRepository namesRepo;

	public Set<PlaceDTO> getPlacesByName(String name) {
		Set<PlaceDTO> places = new HashSet<>();

		List<Name> namesOfPlacesList = new ArrayList<>();
		namesRepo.getPlacesByName(name.toUpperCase()).forEach(namesOfPlacesList::add);

		for (Name n : namesOfPlacesList) {
			for (PlaceInfo p : n.getPlaces()) {
				PlaceDTO dto = new PlaceDTO(p.getPlaceId(), n.getName(),
						(p.getType() == null ? "" : p.getType().getTypeName()), p.getPopulation(), p.getCarbon(),
						p.getPercapcarb(), p.getPopdensity(), p.getPointX(), p.getPointY());
				places.add(dto);
			}
		}

		return places;
	}

}
