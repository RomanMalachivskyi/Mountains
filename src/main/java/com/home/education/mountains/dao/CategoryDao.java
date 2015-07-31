package com.home.education.mountains.dao;

import com.home.education.mountains.resource.impl.Category;

public interface CategoryDao extends ReadGenericDao<Category> {
	Category getByName(String name);
}
