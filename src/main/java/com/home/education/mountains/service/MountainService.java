package com.home.education.mountains.service;

import java.util.Collection;

import com.google.common.collect.Range;
import com.home.education.mountains.common.exception.ResourceException;
import com.home.education.mountains.resource.impl.Mountain;

public interface MountainService extends ReadWriteGenericService<Mountain> {

	Collection<Mountain> getFilteredMountains(Range<Integer> range, Collection<Integer> locationIds);

	Collection<Mountain> getByLocationId(Collection<Integer> locationIds);

	Collection<Mountain> getByName(String mountainName) throws ResourceException;
}
