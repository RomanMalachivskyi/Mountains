package com.home.education.mountains.dao.impl;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.home.education.mountains.dao.ReadWriteGenericDao;
import com.home.education.mountains.resource.GenericResource;

public class ReadWriteGenericDaoImpl<R extends GenericResource> extends ReadGenericDaoImpl<R> implements ReadWriteGenericDao<R> {
	
	private static final Logger LOG = LoggerFactory.getLogger(ReadWriteGenericDaoImpl.class);
	
	public ReadWriteGenericDaoImpl(final String tableName) {
		super(tableName);
	}

	@Override
	public R create(R resource) {
		int id =  (Integer) getHibernateTemplate().save(resource);
		resource.setId(id);
		LOG.info("created "+ tableName +":" + resource.toString());
		return resource;
	}

	@Override
	public R update(R resource) {
		getHibernateTemplate().update(resource);
		LOG.info("updated "+ tableName +":" + resource.toString());
		return resource;
	}

	@Override
	public R delete(R resource) {
		getHibernateTemplate().delete(resource);
		LOG.info("removed "+ tableName +":" + resource.toString());
		return resource;
	}

	@Override
	public Collection<R> delete(Collection<R> resources) {
		getHibernateTemplate().deleteAll(resources);
		LOG.info("removed all "+ tableName +":" + resources.toString());
		return resources;
	}
}
