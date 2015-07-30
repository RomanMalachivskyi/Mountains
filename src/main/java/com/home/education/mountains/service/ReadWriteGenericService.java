package com.home.education.mountains.service;

import com.home.education.mountains.resource.GenericResource;

public interface ReadWriteGenericService<R extends GenericResource> extends ReadGenericService<R> {

	R create (R resource);
}
