package com.home.education.mountains.dao;

import com.home.education.mountains.resource.GenericResource;

public interface ReadWriteGenericDao<R extends GenericResource> extends ReadGenericDao<R> {

	R create(R resource);
}
