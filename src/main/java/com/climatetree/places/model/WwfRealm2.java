package com.climatetree.places.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Mirrors the wwfrealm2 table from the database.
 */
@Entity
@Table(name = "\"WWF_REALM2\"")
public class WwfRealm2 implements Serializable {
	
	public WwfRealm2(int wwfRealm2Id, String wwfRealm2Name, HashSet<PlaceInfo> places) {
		this.wwfRealm2Id = wwfRealm2Id;
		this.wwfRealm2Name = wwfRealm2Name;
		this.places = places;
	}
	
	public WwfRealm2() {
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 9087864223470994142L;

	@Id
	@Column(name = "wwf_realm2_id")
	private int wwfRealm2Id;

	@Column(name = "wwf_realm2_name")
	private String wwfRealm2Name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "wwfRealm2")
	@JsonIgnore
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

	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		if (!super.equals(object)) return false;
		WwfRealm2 wwfRealm2 = (WwfRealm2) object;
		return wwfRealm2Id == wwfRealm2.wwfRealm2Id;
	}

	public int hashCode() {

		return java.util.Objects.hash(super.hashCode(), wwfRealm2Id, wwfRealm2Name, places);
	}
}
