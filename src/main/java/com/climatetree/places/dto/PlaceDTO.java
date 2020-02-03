package com.climatetree.places.dto;

public class PlaceDTO {

	private int placeId;
	private String name;
	private String typeName;
	private double population;
	private double carbon;
	private double percapcarb;
	private double popdensity;

	public int getPlaceId() {
		return placeId;
	}

	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public double getPopulation() {
		return population;
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

	@Override
	public String toString() {
		return "PlaceDTO [placeId=" + placeId + ", name=" + name + ", typeName=" + typeName + ", population="
				+ population + ", carbon=" + carbon + ", percapcarb=" + percapcarb + ", popdensity=" + popdensity + "]";
	}

	public PlaceDTO(int placeId, String name, String typeName, double population, double carbon, double percapcarb,
			double popdensity) {
		this.placeId = placeId;
		this.name = name;
		this.typeName = typeName;
		this.population = population;
		this.carbon = carbon;
		this.percapcarb = percapcarb;
		this.popdensity = popdensity;
	}

}
