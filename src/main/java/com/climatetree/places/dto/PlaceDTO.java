package com.climatetree.places.dto;

public class PlaceDTO {

	private int placeId;
	private String name;
	private String typeName;
	private double population;
	private double carbon;
	private double percapcarb;
	private double popdensity;
	private double pointX;
	private double pointY;

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
				+ population + ", carbon=" + carbon + ", percapcarb=" + percapcarb + ", popdensity=" + popdensity
				+ ", pointX=" + pointX + ", pointY=" + pointY + "]";
	}

	public PlaceDTO(int placeId, String name, String typeName, double population, double carbon, double percapcarb,
			double popdensity, double pointX, double pointY) {
		this.placeId = placeId;
		this.name = name;
		this.typeName = typeName;
		this.population = population;
		this.carbon = carbon;
		this.percapcarb = percapcarb;
		this.popdensity = popdensity;
		this.pointX = pointX;
		this.pointY = pointY;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(carbon);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		temp = Double.doubleToLongBits(percapcarb);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + placeId;
		temp = Double.doubleToLongBits(popdensity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(population);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((typeName == null) ? 0 : typeName.hashCode());
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
		PlaceDTO other = (PlaceDTO) obj;
		if (Double.doubleToLongBits(carbon) != Double.doubleToLongBits(other.carbon))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(percapcarb) != Double.doubleToLongBits(other.percapcarb))
			return false;
		if (placeId != other.placeId)
			return false;
		if (Double.doubleToLongBits(popdensity) != Double.doubleToLongBits(other.popdensity))
			return false;
		if (Double.doubleToLongBits(population) != Double.doubleToLongBits(other.population))
			return false;
		if (typeName == null) {
			if (other.typeName != null)
				return false;
		} else if (!typeName.equals(other.typeName))
			return false;
		return true;
	}

	
	
}
