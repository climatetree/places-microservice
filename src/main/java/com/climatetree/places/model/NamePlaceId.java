package com.climatetree.places.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class NamePlaceId implements Serializable {

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "name_id")
	private Name name;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "place_id")
	private PlaceInfo place;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		NamePlaceId that = (NamePlaceId) o;
		return Objects.equals(name, that.name) && Objects.equals(place, that.place);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, place);
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public PlaceInfo getPlace() {
		return place;
	}

	public void setPlace(PlaceInfo place) {
		this.place = place;
	}

	public NamePlaceId(Name name, PlaceInfo place) {
		this.name = name;
		this.place = place;
	}

	public NamePlaceId() {
		// TODO Auto-generated constructor stub
	}

}
