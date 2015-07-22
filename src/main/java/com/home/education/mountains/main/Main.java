package com.home.education.mountains.main;

import java.sql.SQLException;

import com.home.education.mountains.dao.CategoryDao;
import com.home.education.mountains.dao.impl.CategoryDaoImpl;

public class Main {

	public static void main(String[] args) throws SQLException {
		CategoryDao categoryDao = new CategoryDaoImpl();
		//categoryDao.conn();
		System.out.println(categoryDao.getById(2));
	}

}
