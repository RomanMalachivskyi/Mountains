package com.home.education.mountains.service;

import java.util.Collection;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.beust.jcommander.internal.Lists;
import com.home.education.mountains.common.TestData;
import com.home.education.mountains.common.exception.LocationValidationFailedException;
import com.home.education.mountains.dao.MountainDao;
import com.home.education.mountains.resource.impl.Mountain;
import com.home.education.mountains.service.impl.MountainServiceImpl;

@Test
public class MountainServiceImplTest {

	private Mockery mockery;
	private MountainDao dao;
	private LocationService locationService;
	private MountainServiceImpl service;
	
	@BeforeSuite
	public void before(){
		mockery = new Mockery();
		dao = mockery.mock(MountainDao.class);
		locationService =  mockery.mock(LocationService.class);
		service = new MountainServiceImpl(dao, locationService);
	}
	
	@Test
	public void testGetAllFilteredEmpty() throws LocationValidationFailedException{
		mockery.checking(new Expectations() {
			{
				oneOf(dao).getAll();
				will(returnValue(Lists.newArrayList()));
			}
		});
		Collection<Mountain> result = service.getAllFilterByLocationIdsAndHeight(null, null);
		Assert.assertTrue(result.isEmpty());
	}

	@Test
	public void testGetAllFiltered() throws LocationValidationFailedException{
		final Mountain mountain = TestData.newMountain(1);
		mockery.checking(new Expectations() {
			{
				oneOf(dao).getAll();
				will(returnValue(Lists.newArrayList(mountain)));
			}
		});
		Collection<Mountain> result = service.getAllFilterByLocationIdsAndHeight(null, null);
		Assert.assertTrue(result.isEmpty());
	}
}
