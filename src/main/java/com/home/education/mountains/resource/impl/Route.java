package com.home.education.mountains.resource.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Route")
public class Route extends GenericResourceImpl {

	private int routeId;
	//private Mountain mountain;
	private int mountainId;
	//private Category category;
	private int categoryId;
	private String name;
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

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "mountainId", insertable = false, updatable = false)
//	public Mountain getMountain() {
//		return mountain;
//	}
//
//	public void setMountain(Mountain mountain) {
//		this.mountain = mountain;
//	}
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "categoryId", insertable = false, updatable = false)
//	public Category getCategory() {
//		return category;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}

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
}
