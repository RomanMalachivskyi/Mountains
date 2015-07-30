package com.home.education.mountains.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Iterables;
import com.home.education.mountains.common.CustomHibernateDaoSupport;
import com.home.education.mountains.dao.CategoryDao;
import com.home.education.mountains.resource.impl.Category;

public class CategoryDaoImpl extends CustomHibernateDaoSupport implements CategoryDao {

	private static final Logger log = LoggerFactory.getLogger(CategoryDaoImpl.class);
	
	public Category getById(int id) {
		List<Category> result = (List<Category>) getHibernateTemplate().find("from Category where categoryId=?", id);
		log.info(result.toString());
		return Iterables.getOnlyElement(result);
	}


	public Category getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	public Category create(Category resource) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
