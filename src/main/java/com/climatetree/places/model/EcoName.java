package com.climatetree.places.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="\"ECO_NAME\"")
public class EcoName implements Serializable {

	@Id
	@Column(name = "eco_name_id")
	private int ecoNameId;
	
	@Column(name = "eco_name")
	private String ecoName;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "ecoName")
	@JsonIgnore
	private Set<PlaceInfo> places;

	public int getEcoNameId() {
		return ecoNameId;
	}

	public void setEcoNameId(int ecoNameId) {
		this.ecoNameId = ecoNameId;
	}

	public String getEcoName() {
		return ecoName;
	}

	public void setEcoName(String eco_name) {
		this.ecoName = eco_name;
	}

	public Set<PlaceInfo> getPlaces() {
		return places;
	}

	public void setPlaces(Set<PlaceInfo> places) {
		this.places = places;
	}

	@Override
	public String toString() {
		return "EcoName [ecoNameId=" + ecoNameId + ", ecoName=" + ecoName + ", places=" + places + "]";
	}

}
