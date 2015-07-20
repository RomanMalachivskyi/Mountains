package com.home.education.mountains.dao;

import com.home.education.mountains.resource.impl.Category;

public interface CategoryDao {

	Category getById(int id);
	Category getByName(String name);
}
