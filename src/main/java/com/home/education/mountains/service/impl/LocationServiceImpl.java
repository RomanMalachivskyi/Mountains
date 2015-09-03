package com.home.education.mountains.service.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.home.education.mountains.common.exception.LocationDoesNotExistsException;
import com.home.education.mountains.common.exception.LocationValidationFailedException;
import com.home.education.mountains.common.exception.MountainValidationFailedException;
import com.home.education.mountains.common.exception.ResourceException;
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
	public Collection<Location> getAllFiltered(String mountainRange, String country) throws LocationValidationFailedException {
		Collection<Location> result = getAll();
		if (StringUtils.isNotBlank(mountainRange)) {
			result = result.stream().filter(l -> l.getMountainRange().equals(mountainRange))
					.collect(Collectors.toList());
		}
		
		if (StringUtils.isNotBlank(country)) {
			result = result.stream().filter(l -> l.getCountry().equals(country))
					.collect(Collectors.toList());
		}
		
		return result;
	}
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	public Location create(Location resource) throws ResourceException {
		validateLocation(resource);
		return super.create(resource);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	public Location update(Location resource) throws ResourceException {
		validateLocation(resource);
		return super.update(resource);
	}
	
	@Override
	protected void throwDoesNotExistsException(String msg) throws LocationDoesNotExistsException {
		throw new LocationDoesNotExistsException(msg);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	public Location delete(Location resource) throws ResourceException {
		if(!resource.getMountains().isEmpty()){
			throw new MountainValidationFailedException("can't delete Location, first delete mapped mountains");
		}
		resource.setMountains(null);//FIXME 
		return super.delete(resource);
	}
	
	@Override
	protected void validateLocation(Location resource) throws ResourceException {
		
	}

}
