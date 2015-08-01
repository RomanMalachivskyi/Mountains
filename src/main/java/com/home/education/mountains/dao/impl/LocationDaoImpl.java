package com.home.education.mountains.dao.impl;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.home.education.mountains.dao.LocationDao;
import com.home.education.mountains.resource.impl.Location;

@Repository("locationDao")
public class LocationDaoImpl extends ReadWriteGenericDaoImpl<Location> implements LocationDao {

	private static final Logger LOG = LoggerFactory.getLogger(LocationDaoImpl.class);
	public final static String TABLE_NAME = "Location";
	
	public LocationDaoImpl() {
		super(TABLE_NAME);
	}

	@Override
	public Collection<Location> getByMountainRange(String mountainRange) {
		Collection<Location> result = (Collection<Location>) getHibernateTemplate().find("from Location where mountainRange=?", mountainRange);
		LOG.info("get Locations by MountainRange:" + mountainRange + result.toString());
		return result;
	}
}
