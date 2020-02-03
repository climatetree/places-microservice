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
@Table(name="\"WWF_MHTNAM\"")
public class WwfMhtnam implements Serializable {

	@Id
	@Column(name = "wwf_mhtnam_id")
	private int wwfMhtnamId;
	
	@Column(name = "wwf_mhtnam")
	private String wwfMhtnam;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "wwfMhtnam")
	private Set<PlaceInfo> places;

	public int getWwfMhtnamId() {
		return wwfMhtnamId;
	}

	public void setWwfMhtnamId(int wwfMhtnamId) {
		this.wwfMhtnamId = wwfMhtnamId;
	}

	public String getWwfMhtnam() {
		return wwfMhtnam;
	}

	public void setWwfMhtnam(String wwfMhtnam) {
		this.wwfMhtnam = wwfMhtnam;
	}

	public Set<PlaceInfo> getPlaces() {
		return places;
	}

	public void setPlaces(Set<PlaceInfo> places) {
		this.places = places;
	}

	@Override
	public String toString() {
		return "WwfMhtnam [wwfMhtnamId=" + wwfMhtnamId + ", wwfMhtnam=" + wwfMhtnam + ", places=" + places + "]";
	}

}
