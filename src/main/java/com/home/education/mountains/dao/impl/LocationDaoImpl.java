package com.home.education.mountains.dao.impl;

import org.hibernate.Session;

import com.home.education.mountains.dao.LocationDao;
import com.home.education.mountains.resource.impl.Location;

public class LocationDaoImpl implements LocationDao {

	public Location getById(int id) {
		Session session = SessionFactoryUtils.getSessionFactory().openSession();
		Location location = (Location) session.load(Location.class.getTypeName(), id);
		System.out.println(location);
		session.close();
		return location;
	}
	
	public Location getByName(String locationName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Location create(){
		Session session = SessionFactoryUtils.getSessionFactory().openSession();
		session.beginTransaction();
		Location location = new Location("Alps","France"); 
		session.save(location);
	      
        session.getTransaction().commit();
        session.close();
        return location;
	}

	public Location create(Location resource) {
		Session session = SessionFactoryUtils.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(resource);
	      
        session.getTransaction().commit();
        session.close();
        return resource;
	}
}
