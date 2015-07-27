package com.home.education.mountains.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.home.education.mountains.dao.MountainDao;
import com.home.education.mountains.resource.impl.Mountain;

public class MountainDaoImpl implements MountainDao{

	public Mountain getById(int id) {
		Session session = getSessionFactory().openSession();
		//System.out.println(session.load(Category.class.getTypeName(), id));
		//session.save(new Category("Captain Nemo","fdfdfd"));
	      
        //session.getTransaction().commit();
		List<Mountain> mountain = session.createQuery("from " + Mountain.class.getName()).list();//(Category.class).list();
		Mountain mountain2 = (Mountain) session.load(Mountain.class.getTypeName(), id);
		System.out.println(mountain2);
		session.close();
		
		System.out.println("Found " + mountain.size() );
		
		return mountain2;
	}

	public Mountain getByName(String name) {
		// TODO Auto-generated method stub
		return null;
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
}
