package com.home.education.mountains.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Iterables;
import com.home.education.mountains.common.CustomHibernateDaoSupport;
import com.home.education.mountains.dao.MountainDao;
import com.home.education.mountains.resource.impl.Mountain;

public class MountainDaoImpl extends CustomHibernateDaoSupport implements MountainDao {

	private static final Logger log = LoggerFactory.getLogger(LocationDaoImpl.class);
	
	public Mountain getById(int id) {
		List<Mountain> result = (List<Mountain>) getHibernateTemplate().find("from Mountain where mountainId=?", id);
		log.info(result.toString());
		return Iterables.getOnlyElement(result);
	}

	public Mountain getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Mountain create(Mountain resource) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Mountain> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
