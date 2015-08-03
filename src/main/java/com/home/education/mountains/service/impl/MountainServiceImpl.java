package com.home.education.mountains.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
	public Mountain create(Mountain resource) throws ResourceException {
		validateResource(resource);
		return super.create(resource);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
	public Mountain update(Mountain resource) throws ResourceException {
		validateResource(resource);
		return super.update(resource);
	}
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
	public Mountain delete(Mountain resource) throws ResourceException {
		if(!resource.getRoutes().isEmpty()){
			throw new MountainValidationFailedException("can't delete Muntain, first delete mapped routes");
		}
		resource.setRoutes(null);//FIXME 
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

}
