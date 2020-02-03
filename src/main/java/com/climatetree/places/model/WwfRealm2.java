package com.climatetree.places.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="\"WWF_REALM2\"")
public class WwfRealm2 implements Serializable {

	@Id
	@Column(name = "wwf_realm2_id")
	private int wwfRealm2Id;
	
	@Column(name = "wwf_realm2_name")
	private String wwfRealm2Name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "wwfRealm2")
	private Set<PlaceInfo> places;

	public int getWwfRealm2Id() {
		return wwfRealm2Id;
	}

	public void setWwfRealm2Id(int wwfRealm2Id) {
		this.wwfRealm2Id = wwfRealm2Id;
	}

	public String getWwfRealm2Name() {
		return wwfRealm2Name;
	}

	public void setWwfRealm2Name(String wwfRealm2Name) {
		this.wwfRealm2Name = wwfRealm2Name;
	}

	public Set<PlaceInfo> getPlaces() {
		return places;
	}

	public void setPlaces(Set<PlaceInfo> places) {
		this.places = places;
	}

	@Override
	public String toString() {
		return "WwfRealm2 [wwfRealm2Id=" + wwfRealm2Id + ", wwfRealm2Name=" + wwfRealm2Name + ", places=" + places
				+ "]";
	}

}
