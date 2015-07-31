package com.home.education.mountains.service.impl;

import java.util.Collection;

import com.home.education.mountains.dao.ReadGenericDao;
import com.home.education.mountains.resource.GenericResource;
import com.home.education.mountains.service.ReadGenericService;

public abstract class ReadGenericServiceImpl<R extends GenericResource, D extends ReadGenericDao<R>> implements ReadGenericService<R> {

	protected final D dao;
	
	public ReadGenericServiceImpl(final D dao) {
		this.dao = dao;
	}
	@Override
	public R getById(int resourceId) {
		return dao.getById(resourceId);
	}

	@Override
	public Collection<R> getAll() {
		return dao.getAll();
	}

}
