package com.home.education.mountains.main;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.home.education.mountains.service.LocationService;

public class Main {

	public static void main(String[] args) throws SQLException {
		ApplicationContext appContext = 
		    	  new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
		
		LocationService locationService = (LocationService) appContext.getBean("locationService");
		System.out.println(locationService.getById(2));
//		CategoryDao categoryDao = new CategoryDaoImpl();
//		//categoryDao.conn();
//		System.out.println(categoryDao.getById(2));
//		
//		LocationDaoImpl locationDao = new LocationDaoImpl();
//		//categoryDao.conn();
//		System.out.println(locationDao.getById(2));
//		
//		MountainDao mountainDao = new MountainDaoImpl();
//		//categoryDao.conn();
//		System.out.println(mountainDao.getById(2));
	}

}
