package com.home.education.mountains.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.home.education.mountains.dao.impl.CategoryDaoImpl;
import com.home.education.mountains.resource.impl.Location;
import com.home.education.mountains.service.LocationService;

@Controller
@RequestMapping("/location")
public class LocationController {
	
	private static final Logger log = LoggerFactory.getLogger(CategoryDaoImpl.class);
	
	@Autowired
	private LocationService locationService; 

	@RequestMapping(value= "/{locationId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Location getById(final @PathVariable int locationId){
		log.info("get Location by Id");
		Location location = locationService.getById(locationId);
		return location;
	}
	

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Location> getByMountainRange(@RequestParam(value = "mountainRange", required = true) final String mountainRange){
		log.info("get Locations by mountainRange");
		return locationService.getByMountainRange(mountainRange);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Location create(@RequestBody final Location location){
		log.info("create Location");
		return locationService.create(location);
	}
	
}
