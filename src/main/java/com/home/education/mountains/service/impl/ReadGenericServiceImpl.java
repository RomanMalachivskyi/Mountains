package com.home.education.mountains.service.impl;

import java.util.List;

import com.home.education.mountains.dao.ReadWriteGenericDao;
import com.home.education.mountains.resource.GenericResource;
import com.home.education.mountains.service.ReadGenericService;

public abstract class ReadGenericServiceImpl<R extends GenericResource, D extends ReadWriteGenericDao<R>> implements ReadGenericService<R> {

	protected final D dao;
	public ReadGenericServiceImpl(final D dao) {
		this.dao = dao;
	}
	public R getById(int resourceId) {
		return dao.getById(resourceId);
	}

	public List<R> getAll() {
		return dao.getAll();
	}

}
