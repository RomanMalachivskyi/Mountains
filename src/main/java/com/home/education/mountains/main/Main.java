package com.home.education.mountains.main;

import java.sql.SQLException;

import com.home.education.mountains.dao.CategoryDao;
import com.home.education.mountains.dao.LocationDao;
import com.home.education.mountains.dao.MountainDao;
import com.home.education.mountains.dao.impl.CategoryDaoImpl;
import com.home.education.mountains.dao.impl.LocationDaoImpl;
import com.home.education.mountains.dao.impl.MountainDaoImpl;

public class Main {

	public static void main(String[] args) throws SQLException {
		CategoryDao categoryDao = new CategoryDaoImpl();
		//categoryDao.conn();
		System.out.println(categoryDao.getById(2));
		
		LocationDao locationDao = new LocationDaoImpl();
		//categoryDao.conn();
		System.out.println(locationDao.getById(2));
		
		MountainDao mountainDao = new MountainDaoImpl();
		//categoryDao.conn();
		System.out.println(mountainDao.getById(2));
	}

}
