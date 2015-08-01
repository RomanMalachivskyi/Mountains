package com.home.education.mountains.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.education.mountains.common.exception.ResourceException;
import com.home.education.mountains.dao.MountainDao;
import com.home.education.mountains.resource.impl.Mountain;
import com.home.education.mountains.service.MountainService;

@Service("mountainService")
public class MountainServiceImpl extends ReadWriteGenericServiceImpl<Mountain, MountainDao>implements MountainService {

	@Autowired
	public MountainServiceImpl(MountainDao dao) {
		super(dao);
	}

	@Override
	protected void throwDoesNotExistsException(String msg) throws ResourceException {
		// TODO Auto-generated method stub
		
	}

}
