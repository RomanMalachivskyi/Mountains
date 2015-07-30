package com.home.education.mountains.service;

import java.util.List;

import com.home.education.mountains.resource.impl.Location;

public interface LocationService extends ReadWriteGenericService<Location> {

	List<Location> getByMountainRange(String mountainRange);
}
