package com.home.education.mountains.service;

import java.util.Collection;

import com.home.education.mountains.resource.GenericResource;

public interface ReadGenericService<R extends GenericResource> {

	R getById(int resourceId);
	Collection<R> getAll();
}
