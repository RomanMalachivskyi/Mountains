package com.home.education.mountains.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.education.mountains.dao.LocationDao;
import com.home.education.mountains.resource.impl.Location;
import com.home.education.mountains.service.LocationService;

@Service("locationService")
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationDao locationDao;

	public Location getById(int resourceId) {
		return locationDao.getById(resourceId);
	}

	public List<Location> getByMountainRange(String mountainRange) {
		return locationDao.getByMountainRange(mountainRange);
	}

	public List<Location> getAll() {
		return locationDao.getAll();
	}

	@Transactional(readOnly = false)
	public Location create(Location resource) {
		return locationDao.create(resource);
	}
	
	
}
