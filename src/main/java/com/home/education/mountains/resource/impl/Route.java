package com.home.education.mountains.resource.impl;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Route")
public class Route extends GenericResourceImpl {

	private int id;
	private int mountainId;
}
