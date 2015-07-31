package com.home.education.mountains.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.home.education.mountains.dao.CategoryDao;
import com.home.education.mountains.resource.impl.Category;

@Repository("categoryDao")
public class CategoryDaoImpl extends ReadGenericDaoImpl<Category> implements CategoryDao {

	private static final Logger LOG = LoggerFactory.getLogger(CategoryDaoImpl.class);
	public final static String TABLE_NAME = "Category";
	
	public CategoryDaoImpl() {
		super(TABLE_NAME);
	}

	@Override
	public Category getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
