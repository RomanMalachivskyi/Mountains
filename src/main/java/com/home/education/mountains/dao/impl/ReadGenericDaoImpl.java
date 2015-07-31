package com.home.education.mountains.dao.impl;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Iterables;
import com.home.education.mountains.common.CustomHibernateDaoSupport;
import com.home.education.mountains.dao.ReadGenericDao;
import com.home.education.mountains.resource.GenericResource;

public class ReadGenericDaoImpl<R extends GenericResource> extends CustomHibernateDaoSupport
		implements ReadGenericDao<R> {

	private static final Logger LOG = LoggerFactory.getLogger(ReadGenericDaoImpl.class);
	protected final String tableName;

	public ReadGenericDaoImpl(final String tableName) {
		this.tableName = tableName;
	}

	@Override
	public R getById(int id) {
		Collection<R> result = (Collection<R>) getHibernateTemplate()
				.find("from " + tableName + " where " + tableName.toLowerCase() + "Id=?", id);
		LOG.info("get " + tableName + " by id:" + id + result.toString());
		return Iterables.getOnlyElement(result);
	}

	@Override
	public Collection<R> getAll() {
		LOG.info("get all" + tableName + "s");
		return (Collection<R>) getHibernateTemplate().find("from " + tableName);
	}

}
