package com.home.education.mountains.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.home.education.mountains.dao.MountainDao;
import com.home.education.mountains.resource.impl.Mountain;

public class MountainDaoImpl extends ReadWriteGenericDaoImpl<Mountain> implements MountainDao {

	private static final Logger LOG = LoggerFactory.getLogger(MountainDaoImpl.class);
	public final static String TABLE_NAME = "Mountain";
	
	public MountainDaoImpl(String tableName) {
		super(tableName);
	}
	
	@Override
	public Mountain getByName(String name) {
		return null;
	}
}
