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
@Table(name="\"NAME\"")
public class Name implements Serializable {

	@Id
	@Column(name = "name_id")
	private int nameId;
	
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "id.name", fetch = FetchType.EAGER)
	private Set<NamePlace> namePlaces;

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

	public Set<NamePlace> getNamePlaces() {
		return namePlaces;
	}

	public void setNamePlaces(Set<NamePlace> namePlaces) {
		this.namePlaces = namePlaces;
	}

	@Override
	public String toString() {
		return "Name [nameId=" + nameId + ", name=" + name + ", namePlaces=" + namePlaces + "]";
	}

}
