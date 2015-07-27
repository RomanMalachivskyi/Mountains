package com.home.education.mountains.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.home.education.mountains.dao.LocationDao;
import com.home.education.mountains.resource.impl.Location;

public class LocationDaoImpl implements LocationDao {

	public Location getById(int id) {
		Session session = getSessionFactory().openSession();
		//System.out.println(session.load(Category.class.getTypeName(), id));
		//session.save(new Category("Captain Nemo","fdfdfd"));
	      
        //session.getTransaction().commit();
		List<Location> location = session.createQuery("from " + Location.class.getName()).list();//(Category.class).list();
		Location location2 = (Location) session.load(Location.class.getTypeName(), id);
		System.out.println(location2);
		session.close();
		
		System.out.println("Found " + location.size() );
		
		return location2;
	}
	
	public static SessionFactory getSessionFactory() {
		 try {
	            // Create the SessionFactory from hibernate.cfg.xml
	            return new Configuration().configure().buildSessionFactory();
	        } catch (Throwable ex) {
	            // Make sure you log the exception, as it might be swallowed
	            System.err.println("Initial SessionFactory creation failed." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	}

	public Location getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
