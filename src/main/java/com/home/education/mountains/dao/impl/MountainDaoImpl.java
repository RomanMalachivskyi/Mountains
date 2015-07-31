package com.home.education.mountains.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.home.education.mountains.dao.MountainDao;
import com.home.education.mountains.resource.impl.Mountain;

@Repository("mountainDao")
public class MountainDaoImpl extends ReadWriteGenericDaoImpl<Mountain> implements MountainDao {

	private static final Logger LOG = LoggerFactory.getLogger(MountainDaoImpl.class);
	public final static String TABLE_NAME = "Mountain";
	
	public MountainDaoImpl() {
		super(TABLE_NAME);
	}
	
	@Override
	public Mountain getByName(String name) {
		return null;
	}
}
