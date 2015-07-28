package com.home.education.mountains.dao;

import com.home.education.mountains.resource.GenericResource;

public interface GenericDao <R extends GenericResource>{

	R getById(int id);
	R getByName(String name);
	R create(R resource);
	
}
