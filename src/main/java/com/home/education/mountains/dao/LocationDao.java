package com.home.education.mountains.dao;

import java.util.List;

import com.home.education.mountains.resource.impl.Location;

public interface LocationDao extends ReadWriteGenericDao<Location> {

	List<Location> getByMountainRange(String mountainRange) ;
}
