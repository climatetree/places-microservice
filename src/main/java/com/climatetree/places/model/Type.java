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
 * Mirrors the Type table from the database.
 */
@Entity
@Table(name = "\"TYPE\"")
public class Type implements Serializable {
	
	public Type(int typeId, String typeName, HashSet<PlaceInfo> places) {
		this.typeId = typeId;
		this.typeName = typeName;
		this.places = places;
	}
	
	public Type() {
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8130883750882226588L;

	@Id
	@Column(name = "type_id")
	private int typeId;

	@Column(name = "type_name")
	private String typeName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
	@JsonIgnore
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

	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		if (!super.equals(object)) return false;
		Type type = (Type) object;
		return typeId == type.typeId;
	}

	public int hashCode() {

		return java.util.Objects.hash(super.hashCode(), typeId, typeName, places);
	}
}
