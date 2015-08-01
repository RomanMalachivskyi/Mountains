package com.home.education.mountains.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.education.mountains.common.exception.ResourceException;
import com.home.education.mountains.dao.RouteDao;
import com.home.education.mountains.resource.impl.Route;
import com.home.education.mountains.service.RouteService;

@Service("routeService")
public class RouteServiceImpl extends ReadWriteGenericServiceImpl<Route, RouteDao>implements RouteService {

	@Autowired
	public RouteServiceImpl(RouteDao dao) {
		super(dao);
	}

	@Override
	public Route getByName(String routeName) {
		return null;
	}

	@Override
	protected void throwDoesNotExistsException(String msg) throws ResourceException {

	}
}
