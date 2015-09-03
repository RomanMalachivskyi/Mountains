package com.home.education.mountains.service.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Range;
import com.home.education.mountains.common.exception.MountainDoesNotExistsException;
import com.home.education.mountains.common.exception.MountainValidationFailedException;
import com.home.education.mountains.common.exception.ResourceException;
import com.home.education.mountains.dao.MountainDao;
import com.home.education.mountains.resource.impl.Mountain;
import com.home.education.mountains.service.LocationService;
import com.home.education.mountains.service.MountainService;

@Service("mountainService")
public class MountainServiceImpl extends ReadWriteGenericServiceImpl<Mountain, MountainDao>implements MountainService {

	private final LocationService locationService;

	@Autowired
	public MountainServiceImpl(MountainDao dao, LocationService locationService) {
		super(dao);
		this.locationService = locationService;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	public Mountain create(Mountain resource) throws ResourceException {
		validateLocation(resource);
		return super.create(resource);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	public Mountain update(Mountain resource) throws ResourceException {
		validateLocation(resource);
		return super.update(resource);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
	public Mountain delete(Mountain resource) throws ResourceException {
		if (!resource.getRoutes().isEmpty()) {
			throw new MountainValidationFailedException("can't delete Mountain, first delete mapped routes");
		}
		resource.setRoutes(null);// FIXME
		return super.delete(resource);
	}

	@Override
	protected void throwDoesNotExistsException(String msg) throws MountainDoesNotExistsException {
		throw new MountainDoesNotExistsException(msg);
	}

	@Override
	protected void validateLocation(Mountain resource) throws ResourceException {
		locationService.getById(resource.getLocationId());
	}

	@Override
	public Collection<Mountain> getFilteredMountains(Range<Integer> range) {
		Collection<Mountain> result = getAll();
		if(range != null && range.hasLowerBound() && range.hasUpperBound()){
			result = result.stream().filter(m -> (m.getHeight() >= range.lowerEndpoint())).
					filter(m -> (m.getHeight() <= range.upperEndpoint())).
					collect(Collectors.toList());
		}
		return result;
	}

}
