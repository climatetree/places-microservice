package com.climatetree.places.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.climatetree.places.dto.PlaceDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "\"PLACE_INFO\"")
public class PlaceInfo implements Serializable {
	
	public PlaceInfo(int placeId, Type type, EcoName ecoName, WwfMhtnam wwfMhtnam, WwfRealm2 wwfRealm2, double population,
					double carbon, double percapcarb, double popdensity, String hasc1, double pointX, double pointY) {
		this.placeId = placeId;
		this.type = type;
		this.ecoName = ecoName;
		this.wwfMhtnam = wwfMhtnam;
		this.wwfRealm2 = wwfRealm2;
		this.carbon = carbon;
		this.percapcarb = percapcarb;
		this.population = population;
		this.popdensity = popdensity;
		this.hasc1 = hasc1;
		this.pointX = pointX;
		this.pointY = pointY;
	}
	
	
	public PlaceInfo() {
	
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = -7407606649493169837L;

	@Id
	@Column(name = "place_id")
	private int placeId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_id")
	private Type type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "eco_name_id")
	private EcoName ecoName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "wwf_mhtnam_id")
	private WwfMhtnam wwfMhtnam;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "wwf_realm2_id")
	private WwfRealm2 wwfRealm2;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "places")
	@JsonBackReference
	private Set<Name> names;

	private double population;

	private double carbon;

	private double percapcarb;

	private double popdensity;

	@Column(name = "hasc_1")
	private String hasc1;
	@Column(name = "point_x")
	private double pointX;

	@Column(name = "point_y")
	private double pointY;

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

	public double getPopulation() {
		return population;
	}

	public Set<Name> getNames() {
		return names;
	}

	public void setNames(Set<Name> names) {
		this.names = names;
	}

	public void setPopulation(double population) {
		this.population = population;
	}

	public double getCarbon() {
		return carbon;
	}

	public void setCarbon(double carbon) {
		this.carbon = carbon;
	}

	public double getPercapcarb() {
		return percapcarb;
	}

	public void setPercapcarb(double percapcarb) {
		this.percapcarb = percapcarb;
	}

	public double getPopdensity() {
		return popdensity;
	}

	public void setPopdensity(double popdensity) {
		this.popdensity = popdensity;
	}

	public String getHasc1() {
		return hasc1;
	}

	public void setHasc1(String hasc1) {
		this.hasc1 = hasc1;
	}

	public double getPointX() {
		return pointX;
	}

	public void setPointX(double pointX) {
		this.pointX = pointX;
	}

	public double getPointY() {
		return pointY;
	}

	public void setPointY(double pointY) {
		this.pointY = pointY;
	}
	
	
	public PlaceInfo(int placeId, Type type, EcoName ecoName, WwfMhtnam wwfMhtnam, WwfRealm2 wwfRealm2, Set<Name> names,
			double population, double carbon, double percapcarb, double popdensity, String hasc1, double pointX,
			double pointY) {
		this.placeId = placeId;
		this.type = type;
		this.ecoName = ecoName;
		this.wwfMhtnam = wwfMhtnam;
		this.wwfRealm2 = wwfRealm2;
		this.names = names;
		this.population = population;
		this.carbon = carbon;
		this.percapcarb = percapcarb;
		this.popdensity = popdensity;
		this.hasc1 = hasc1;
		this.pointX = pointX;
		this.pointY = pointY;
	}


	@Override
	public String toString() {
		return "PlaceInfo [placeId=" + placeId + ", type=" + type + ", ecoName=" + ecoName + ", wwfMhtnam=" + wwfMhtnam
				+ ", wwfRealm2=" + wwfRealm2 + ", names count=" + names.size() + ", population=" + population
				+ ", carbon=" + carbon + ", percapcarb=" + percapcarb + ", popdensity=" + popdensity + ", hasc1="
				+ hasc1 + ", pointX=" + pointX + ", pointY=" + pointY + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + placeId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlaceInfo other = (PlaceInfo) obj;
		if (placeId != other.placeId)
			return false;
		return true;
	}


}
