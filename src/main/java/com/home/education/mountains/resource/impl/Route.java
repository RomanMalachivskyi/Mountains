package com.home.education.mountains.resource.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Route")
public class Route extends GenericResourceImpl {

	private int routeId;
	@NotNull(message = "Route should have connectivity with Mountain")
	private int mountainId;
	@NotNull(message = "Route should have connectivity with Category")
	private int categoryId;
	@NotBlank(message = "RouteName cann't be empty")
	@Length(max = 45, message = "RouteName cannot be greater than 45 characters")
	private String name;
	@Length(max = 100, message = "Description cannot be greater than 100 characters")
	private String decription;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "routeId", unique = true, nullable = false)
	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "decription")
	public String getDecription() {
		return decription;
	}

	public void setDecription(String decription) {
		this.decription = decription;
	}

	@Column(name="mountainId")
	public int getMountainId() {
		return mountainId;
	}

	public void setMountainId(int mountainId) {
		this.mountainId = mountainId;
	}

	@Column(name="categoryId")
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	@JsonIgnore
	public int getId() {
		return getRouteId();
	}

	@Override
	public void setId(int id) {
		setRouteId(id);
	}
}
