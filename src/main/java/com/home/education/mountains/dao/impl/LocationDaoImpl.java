package com.home.education.mountains.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Iterables;
import com.home.education.mountains.common.CustomHibernateDaoSupport;
import com.home.education.mountains.common.SessionFactoryUtils;
import com.home.education.mountains.dao.LocationDao;
import com.home.education.mountains.resource.impl.Location;

@Repository("locationDao")
public class LocationDaoImpl extends CustomHibernateDaoSupport implements LocationDao {

	private static final Logger log = LoggerFactory.getLogger(LocationDaoImpl.class);

	public Location getById(int id) {
		List<Location> result = (List<Location>) getHibernateTemplate().find("from Location where locationId=?", id);
		log.info(result.toString());
		return Iterables.getOnlyElement(result);
//		Session session = SessionFactoryUtils.getSessionFactory().openSession();
//		Location location = (Location) session.load(Location.class.getTypeName(), id);
//		log.info(location.toString());
//		session.close();
//		return location;
	}

	public List<Location> getByMountainRange(String mountainRange) {
		List<Location> result = (List<Location>) getHibernateTemplate().find("from Location where mountainRange=?", mountainRange);
		log.info(result.toString());
		return result;
	}

	public Location create() {
		Session session = SessionFactoryUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Location location = new Location("Alps", "France");
		session.save(location);

		session.getTransaction().commit();
		session.close();
		return location;
	}

	
	public Location create(Location resource) {
		int locationId =  (Integer) getHibernateTemplate().save(resource);
		resource.setLocatioId(locationId);
		return resource;
//		Session session = SessionFactoryUtils.getSessionFactory().openSession();
//		session.beginTransaction();
//		session.save(resource);
//
//		session.getTransaction().commit();
//		session.close();
//		return resource;
	}

	public List<Location> getAll() {
		return (List<Location>) getHibernateTemplate().find("from Location");
	}
}
