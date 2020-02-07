package com.climatetree.places.utils;

import com.climatetree.places.dto.PlaceDTO;
import com.climatetree.places.model.PlaceInfo;

public class Mapper {
	
	/**
	 * Converts a PlaceInfo object to a PlaceDTO object. If the names set has a name, the first name will be taken.
	 * @param place PlaceInfo object
	 * @return placeDTO object
	 */
	public static PlaceDTO placeInfoToPlaceDTO(PlaceInfo place) {
		String name = (place.getNames() == null || place.getNames().isEmpty()) ? null : place.getNames().iterator().next().getName();
		String typeName = (place.getType() == null) ? null : place.getType().getTypeName();
		
		return new PlaceDTO(place.getPlaceId(), 
							name, 
							typeName, 
							place.getPopulation(), 
							place.getCarbon(), 
							place.getPercapcarb(), 
							place.getPopdensity(),
							place.getPointX(),
							place.getPointY());
	}

}
