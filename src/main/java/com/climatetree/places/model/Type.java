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
@Table(name="\"TYPE\"")
public class Type implements Serializable {

	@Id
	@Column(name = "type_id")
	private int typeId;
	
	@Column(name = "type_name")
	private String typeName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
	private Set<PlaceInfo> places;

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Set<PlaceInfo> getPlaces() {
		return places;
	}

	public void setPlaces(Set<PlaceInfo> places) {
		this.places = places;
	}

	@Override
	public String toString() {
		return "Type [typeId=" + typeId + ", typeName=" + typeName + ", places=" + places + "]";
	}

}
