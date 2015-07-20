package com.home.education.mountains.main;

import java.sql.SQLException;

import com.home.education.mountains.dao.CategoryDao;
import com.home.education.mountains.dao.impl.CategoryDaoImpl;

public class Main {

	public static void main(String[] args) throws SQLException {
		CategoryDaoImpl categoryDao = new CategoryDaoImpl();
		//categoryDao.conn();
		categoryDao.getById(2);
	}

}
