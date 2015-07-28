package com.home.education.mountains.resource.impl;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Mountain", uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
public class Mountain extends GenericResourceImpl {

	private int mountainId;
	private String name;
	private Location location;
	private String description;
	private int height;
	private List<Route> routes; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mountainId", unique = true, nullable = false)
	public int getMountainId() {
		return mountainId;
	}
	
	public void setMountainId(int mountainId) {
		this.mountainId = mountainId;
	}
	
	@Column(name = "name", unique = true, nullable = false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "height")
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "locationId", nullable = false, insertable = false, updatable=false)
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@OneToMany(mappedBy= "mountain", fetch=FetchType.LAZY)
	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}
}
