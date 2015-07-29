package com.home.education.mountains.dao.impl;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.home.education.mountains.common.SessionFactoryUtils;
import com.home.education.mountains.dao.MountainDao;
import com.home.education.mountains.resource.impl.Mountain;

public class MountainDaoImpl implements MountainDao {

	private static final Logger log = LoggerFactory.getLogger(LocationDaoImpl.class);
	
	public Mountain getById(int id) {
		Session session = SessionFactoryUtils.getSessionFactory().openSession();
		Mountain mountain = (Mountain) session.load(Mountain.class.getTypeName(), id);
		log.info(mountain.toString());
		session.close();
		return mountain;
	}

	public Mountain getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Mountain create(Mountain resource) {
		// TODO Auto-generated method stub
		return null;
	}

}
