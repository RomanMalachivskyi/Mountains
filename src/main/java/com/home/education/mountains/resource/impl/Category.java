package com.home.education.mountains.resource.impl;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Category")
public class Category extends GenericResourceImpl implements Serializable {

	private static final long serialVersionUID = -6737556781595570134L;

	private int categoryId;
	private String name;
	private String description;

	public Category() {
	}
	
	public Category(int categoryId, String name, String description) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.description = description;
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
	
}
