package com.home.education.mountains.resource.impl;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Location")
public class Location extends GenericResourceImpl {

	private int locationId;
	private String mountainRange;
	private String country;
	private String description;
	private List<Mountain> mountains;

	public Location() {
		// TODO Auto-generated constructor stub
	}
	
	public Location(String mountainRange, String country) {
		super();
		this.mountainRange = mountainRange;
		this.country = country;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "locationId", unique = true, nullable = false)
	public int getLocatioId() {
		return locationId;
	}

	public void setLocatioId(int locationId) {
		this.locationId = locationId;
	}

	@Column(name = "mountainRange", nullable = false)
	public String getMountainRange() {
		return mountainRange;
	}

	public void setMountainRange(String mountainRange) {
		this.mountainRange = mountainRange;
	}

	@Column(name = "country", nullable = false)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "description", nullable = true)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	};

	@OneToMany( mappedBy = "location", fetch = FetchType.LAZY)
	public List<Mountain> getMountains() {
		return mountains;
	}

	public void setMountains(List<Mountain> mountains) {
		this.mountains = mountains;
	}
}
