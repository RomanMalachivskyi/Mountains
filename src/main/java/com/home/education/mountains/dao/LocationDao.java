package com.home.education.mountains.dao;

import com.home.education.mountains.resource.impl.Location;

public interface LocationDao {

	Location getById(int id);
	Location getByName(String name);
}
