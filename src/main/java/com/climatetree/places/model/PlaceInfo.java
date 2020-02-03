package com.climatetree.places.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="\"PLACE_INFO\"")
public class PlaceInfo implements Serializable {

	@Id
	@Column(name = "place_id")
	private int placeId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "type_id")
	private Type type;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "eco_name_id")
	private EcoName ecoName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "wwf_mhtnam_id")
	private WwfMhtnam wwfMhtnam;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "wwf_realm2")
	private WwfRealm2 wwfRealm2;

	@OneToMany(mappedBy = "id.place", fetch = FetchType.EAGER)
	private Set<NamePlace> namePlaces;

	public int getPlaceId() {
		return placeId;
	}

	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public EcoName getEcoName() {
		return ecoName;
	}

	public void setEcoName(EcoName ecoName) {
		this.ecoName = ecoName;
	}

	public WwfMhtnam getWwfMhtnam() {
		return wwfMhtnam;
	}

	public void setWwfMhtnam(WwfMhtnam wwfMhtnam) {
		this.wwfMhtnam = wwfMhtnam;
	}

	public WwfRealm2 getWwfRealm2() {
		return wwfRealm2;
	}

	public void setWwfRealm2(WwfRealm2 wwfRealm2) {
		this.wwfRealm2 = wwfRealm2;
	}

	public Set<NamePlace> getNamePlaces() {
		return namePlaces;
	}

	public void setNamePlaces(Set<NamePlace> namePlaces) {
		this.namePlaces = namePlaces;
	}

	@Override
	public String toString() {
		return "PlaceInfo [placeId=" + placeId + ", type=" + type + ", ecoName=" + ecoName + ", wwfMhtnam=" + wwfMhtnam
				+ ", wwfRealm2=" + wwfRealm2 + ", namePlaces=" + namePlaces + "]";
	}

}
