package com.home.education.mountains.dao.impl;

import java.util.Collection;

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

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Category> getByName(String name) {
		LOG.info("get Category by name");
		return (Collection<Category>) getHibernateTemplate()
				.find("from " + tableName + " where name=?", name);
	}
}
