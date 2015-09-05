package com.home.education.mountains.service.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import com.home.education.mountains.common.exception.MountainDoesNotExistsException;
import com.home.education.mountains.common.exception.MountainValidationFailedException;
import com.home.education.mountains.common.exception.ResourceException;
import com.home.education.mountains.dao.MountainDao;
import com.home.education.mountains.resource.impl.Mountain;
import com.home.education.mountains.service.LocationService;
import com.home.education.mountains.service.MountainService;

@Service("mountainService")
@Transactional(rollbackFor = ResourceException.class)
public class MountainServiceImpl extends ReadWriteGenericServiceImpl<Mountain, MountainDao>implements MountainService {

	private final LocationService locationService;

	@Autowired
	public MountainServiceImpl(MountainDao dao, LocationService locationService) {
		super(dao);
		this.locationService = locationService;
	}

	@Override
	public Mountain create(Mountain resource) throws ResourceException {
		validateResource(resource);
		return super.create(resource);
	}

	@Override
	public Mountain update(Mountain resource) throws ResourceException {
		validateResource(resource);
		return super.update(resource);
	}

	@Override
	public Mountain delete(Mountain resource) throws ResourceException {

		return super.delete(resource);
	}

	@Override
	protected void throwDoesNotExistsException(String msg) throws MountainDoesNotExistsException {
		throw new MountainDoesNotExistsException(msg);
	}

	@Override
	protected void validateResource(Mountain resource) throws ResourceException {
		locationService.getById(resource.getLocationId());
	}

	@Override
	public Collection<Mountain> getFilteredMountains(Range<Integer> range, Collection<Integer> locationIds) {
		Collection<Mountain> result = getByLocationId(locationIds);
		if (result == null || result.isEmpty()) {
			return Lists.newArrayList();
		}
		if (range != null && range.hasLowerBound() && range.hasUpperBound()) {
			result = result.stream().filter(m -> (m.getHeight() >= range.lowerEndpoint()))
					.filter(m -> (m.getHeight() <= range.upperEndpoint())).collect(Collectors.toList());
		}
		return result;
	}

	@Override
	public Collection<Mountain> getByLocationId(Collection<Integer> locationIds) {
		return dao.getViaLocationIds(locationIds);
	}
	@Override
	public Collection<Mountain> getByName(String mountainName) throws ResourceException {
		if(StringUtils.isBlank(mountainName)){
			throw new MountainValidationFailedException("MountainName is not valid");
		}
		Collection<Mountain> results = dao.getByName(mountainName);
		if(results.isEmpty()){
			throwDoesNotExistsException(" does not exists");
		}
		return results;
	}

	
}
