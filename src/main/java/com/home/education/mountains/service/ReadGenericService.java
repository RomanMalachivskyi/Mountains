package com.home.education.mountains.service;

import java.util.List;

import com.home.education.mountains.resource.GenericResource;

public interface ReadGenericService<R extends GenericResource> {

	R getById(int resourceId);
	List<R> getAll();
}
