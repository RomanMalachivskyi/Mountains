package com.home.education.mountains.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.home.education.mountains.common.exception.ResourceException;
import com.home.education.mountains.common.exception.RouteDoesNotExistsException;
import com.home.education.mountains.dao.RouteDao;
import com.home.education.mountains.resource.impl.Route;
import com.home.education.mountains.service.CategoryService;
import com.home.education.mountains.service.MountainService;
import com.home.education.mountains.service.RouteService;

@Service("routeService")
public class RouteServiceImpl extends ReadWriteGenericServiceImpl<Route, RouteDao>implements RouteService {

	private final MountainService mountainService;
	private final CategoryService categoryService;

	@Autowired
	public RouteServiceImpl(RouteDao dao, final MountainService mountainService,
			final CategoryService categoryService) {
		super(dao);
		this.categoryService = categoryService;
		this.mountainService = mountainService;
	}

	@Override
	public Route getByName(String routeName) {
		return null;
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
	public Route create(Route resource) throws ResourceException {
		validateLocation(resource);
		return super.create(resource);
	}

	@Override
	protected void validateLocation(Route resource) throws ResourceException {
		mountainService.getById(resource.getMountainId());
		categoryService.getById(resource.getCategoryId());
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
	public Route update(Route resource) throws ResourceException {
		validateLocation(resource);
		return super.update(resource);
	}

	@Override
	protected void throwDoesNotExistsException(String msg) throws RouteDoesNotExistsException {
		throw new RouteDoesNotExistsException(msg);
	}
}
