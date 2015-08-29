package com.home.education.mountains.service;

import org.springframework.security.access.prepost.PreAuthorize;

import com.home.education.mountains.common.exception.ResourceException;
import com.home.education.mountains.resource.GenericResource;
//@PreAuthorize("hasRole('ROLE_USER')")
public interface ReadWriteGenericService<R extends GenericResource> extends ReadGenericService<R> {

	R create (R resource) throws ResourceException;
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	R update (R resource) throws ResourceException;
	R delete (R resource) throws ResourceException;
}
