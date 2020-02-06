package com.climatetree.places.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "\"NAME\"")
public class Name implements Serializable {

	@Id
	@Column(name = "name_id")
	private int nameId;

	@Column(name = "name")
	private String name;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "\"NAME_PLACE\"", joinColumns = {
			@JoinColumn(name = "NAME_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "PLACE_ID", nullable = false, updatable = false) })
	@JsonManagedReference
	private Set<PlaceInfo> places;

	public int getNameId() {
		return nameId;
	}

	public void setNameId(int nameId) {
		this.nameId = nameId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<PlaceInfo> getPlaces() {
		return places;
	}

	public void setPlaces(Set<PlaceInfo> places) {
		this.places = places;
	}

	@Override
	public String toString() {
		return "Name [nameId=" + nameId + ", name=" + name + ", places count=" + places.size() + "]";
	}
	
	

}
