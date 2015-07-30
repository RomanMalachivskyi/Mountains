package com.home.education.mountains.dao;

import java.util.List;

import com.home.education.mountains.resource.GenericResource;

public interface ReadGenericDao <R extends GenericResource>{

	R getById(int id);
	List<R> getAll();
	
}
