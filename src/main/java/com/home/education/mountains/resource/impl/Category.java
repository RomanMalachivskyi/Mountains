package com.home.education.mountains.resource.impl;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@Entity
@Table(name="Category")
@JsonSerialize
public class Category extends GenericResourceImpl{

	private static final long serialVersionUID = -203735393745080990L;
	private int categoryId;
	private String name;
	private String description;
	private List<Route> routes;

	public Category() {
		// TODO Auto-generated constructor stub
	}
	public Category(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoryId", unique = true, nullable = false)
	public int getId() {
		return categoryId;
	}

	public void setId(int categoryId) {
		this.categoryId = categoryId;
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

	@OneToMany(mappedBy = "categoryId", fetch = FetchType.LAZY)
	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}
	
}
