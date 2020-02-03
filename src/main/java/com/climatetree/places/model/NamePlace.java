package com.climatetree.places.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "\"NAME_PLACE\"")
public class NamePlace implements Serializable {

	@EmbeddedId
	private NamePlaceId id;

	@Column(name = "date")
	private Date date;

	public NamePlaceId getId() {
		return id;
	}

	public void setId(NamePlaceId id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "NamePlace [id=" + id + ", date=" + date + "]";
	}

}
