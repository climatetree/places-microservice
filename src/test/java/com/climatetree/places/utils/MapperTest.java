package com.climatetree.places.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.climatetree.places.dto.PlaceDTO;
import com.climatetree.places.model.EcoName;
import com.climatetree.places.model.Name;
import com.climatetree.places.model.PlaceInfo;
import com.climatetree.places.model.Type;
import com.climatetree.places.model.WwfMhtnam;
import com.climatetree.places.model.WwfRealm2;
import com.climatetree.places.utils.Mapper;

class MapperTest {
	
	PlaceInfo input;
	
	@BeforeEach
	void setup() {
		Type type = new Type(1, "type", new HashSet<PlaceInfo>());
		EcoName ecoName = new EcoName(2, "ecoName", new HashSet<PlaceInfo>());
		WwfMhtnam wwfmhtnam = new WwfMhtnam(3, "wwfmhtnam", new HashSet<PlaceInfo>());
		WwfRealm2 wwfrealm2 = new WwfRealm2(4, "wwfrealm2", new HashSet<PlaceInfo>());
		input = new PlaceInfo(0, type, ecoName, wwfmhtnam, wwfrealm2, 1.0, 2.0, 3.0, 4.0, "hasc1", 5.0, 6.0);
	}
	

	@Test
	void testConvertToDTO1() {
		PlaceDTO expected = new PlaceDTO(0, null, "type", 1.0, 2.0, 3.0, 4.0, 5, 6);
		PlaceDTO actual = Mapper.placeInfoToPlaceDTO(input);
		
		// Assert
		assertThat(actual).isEqualTo(expected);
		
	}
	
	@Test
	void testConvertToDTO2() {
		HashSet<Name> names = new HashSet<>();
		Name name = new Name();
		name.setName("USA");
		names.add(name);
		input.setNames(names);
		PlaceDTO expected = new PlaceDTO(0, "USA", "type", 1.0, 2.0, 3.0, 4.0, 5, 6);
		PlaceDTO actual = Mapper.placeInfoToPlaceDTO(input);
		
		// Assert
		assertThat(actual).isEqualTo(expected);
		
	}
	
	@Test
	void testConvertToDTO3() {
		input.setNames(new HashSet<Name>());
		PlaceDTO expected = new PlaceDTO(0, null, "type", 1.0, 2.0, 3.0, 4.0, 5, 6);
		PlaceDTO actual = Mapper.placeInfoToPlaceDTO(input);
		
		// Assert
		assertThat(actual).isEqualTo(expected);
		
	}
	
	@Test
	void testConvertToDTO4() {
		input.setType(new Type());
		PlaceDTO expected = new PlaceDTO(0, null, null, 1.0, 2.0, 3.0, 4.0, 5, 6);
		PlaceDTO actual = Mapper.placeInfoToPlaceDTO(input);
		
		// Assert
		assertThat(actual).isEqualTo(expected);
		
	}
	
	@Test
	void testConvertToDTO5() {
		input.setType(null);
		PlaceDTO expected = new PlaceDTO(0, null, null, 1.0, 2.0, 3.0, 4.0, 5, 6);
		PlaceDTO actual = Mapper.placeInfoToPlaceDTO(input);
		
		// Assert
		assertThat(actual).isEqualTo(expected);
		
	}

}
