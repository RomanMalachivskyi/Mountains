package com.home.education.mountains.service;

import com.home.education.mountains.resource.impl.Route;

public interface RouteService extends ReadWriteGenericService<Route> {

	Route getByName(String routeName);
}
