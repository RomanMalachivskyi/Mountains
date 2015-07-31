package com.home.education.mountains.dao.impl;

import org.springframework.stereotype.Repository;

import com.home.education.mountains.dao.RouteDao;
import com.home.education.mountains.resource.impl.Route;

@Repository("routeDao")
public class RouteDaoImpl extends ReadWriteGenericDaoImpl<Route> implements RouteDao {

	public final static String TABLE_NAME = "Route";
	
	public RouteDaoImpl() {
		super(TABLE_NAME);
	}
}
