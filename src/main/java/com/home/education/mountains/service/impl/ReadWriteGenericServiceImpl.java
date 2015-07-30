package com.home.education.mountains.service.impl;

import com.home.education.mountains.dao.ReadWriteGenericDao;
import com.home.education.mountains.resource.GenericResource;
import com.home.education.mountains.service.ReadWriteGenericService;

public abstract class ReadWriteGenericServiceImpl<R extends GenericResource, D extends ReadWriteGenericDao<R>> extends ReadGenericServiceImpl<R, ReadWriteGenericDao<R>> implements ReadWriteGenericService<R> {

	
	public ReadWriteGenericServiceImpl(final D dao) {
		super(dao);
	}
	

	public R create(R resource) {
		// TODO Auto-generated method stub
		return null;
	}

}
