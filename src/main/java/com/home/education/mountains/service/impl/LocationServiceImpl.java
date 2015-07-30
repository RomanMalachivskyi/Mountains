package com.home.education.mountains.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.education.mountains.common.exception.LocationValidationFailedException;
import com.home.education.mountains.dao.LocationDao;
import com.home.education.mountains.resource.impl.Location;
import com.home.education.mountains.service.LocationService;

@Service("locationService")
public class LocationServiceImpl extends ReadWriteGenericServiceImpl<Location, LocationDao>implements LocationService {

	@Autowired
	public LocationServiceImpl(final LocationDao dao) {
		super(dao);
	}

	@Override
	public Location getById(int resourceId) {
		return super.getById(resourceId);
	}

	@Override
	public List<Location> getByMountainRange(String mountainRange) throws LocationValidationFailedException {
		if (StringUtils.isBlank(mountainRange)) {
			throw new LocationValidationFailedException(
					"Location validation failed. Reason mountainRange  " + mountainRange + " is invalid");
		}
		List<Location> result = dao.getAll().stream().filter(l -> l.getMountainRange().equals(mountainRange))
				.collect(Collectors.toList());
		return result;
	}

	@Override
	public List<Location> getAll() {
		return super.getAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Location create(Location resource) {
		return super.create(resource);
	}

}
