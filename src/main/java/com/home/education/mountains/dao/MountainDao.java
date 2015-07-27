package com.home.education.mountains.dao;

import com.home.education.mountains.resource.impl.Mountain;

public interface MountainDao {

	Mountain getById(int id);
	Mountain getByName(String name);
}
