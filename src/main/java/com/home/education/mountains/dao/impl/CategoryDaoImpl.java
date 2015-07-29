package com.home.education.mountains.dao.impl;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.home.education.mountains.common.SessionFactoryUtils;
import com.home.education.mountains.dao.CategoryDao;
import com.home.education.mountains.resource.impl.Category;

public class CategoryDaoImpl implements CategoryDao {

	private static final Logger log = LoggerFactory.getLogger(CategoryDaoImpl.class);
	
	public Category getById(int id) {
		Session session = SessionFactoryUtils.getSessionFactory().openSession();
		Category category = (Category) session.load(Category.class.getTypeName(), id);
		log.info(category.toString());
		session.close();
		
		return category;
	}


	public Category getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	public Category create(Category resource) {
		// TODO Auto-generated method stub
		return null;
	}
}
