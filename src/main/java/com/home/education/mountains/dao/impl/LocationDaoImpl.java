package com.home.education.mountains.dao.impl;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.home.education.mountains.dao.LocationDao;
import com.home.education.mountains.resource.impl.Location;

@Repository("locationDao")
public class LocationDaoImpl extends ReadWriteGenericDaoImpl<Location> implements LocationDao {

	public final static String TABLE_NAME = "Location";
	
	public LocationDaoImpl() {
		super(TABLE_NAME);
	}

	private static final Logger log = LoggerFactory.getLogger(LocationDaoImpl.class);

	@Override
	public Location getById(int id) {
		return super.getById(id);
	}

	@Override
	public Collection<Location> getByMountainRange(String mountainRange) {
		Collection<Location> result = (Collection<Location>) getHibernateTemplate().find("from Location where mountainRange=?", mountainRange);
		log.info("get Locations by MountainRange:" + mountainRange + result.toString());
		return result;
	}
	
	@Override
	public Location update(Location resource) {
		getHibernateTemplate().update(resource);
		return resource;
	}

	@Override
	public Location delete(Location resource) {
		getHibernateTemplate().delete(resource);
		return null;
	}
}
