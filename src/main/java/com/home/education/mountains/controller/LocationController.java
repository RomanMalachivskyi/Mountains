package com.home.education.mountains.controller;

import java.util.Collection;

import javax.validation.Valid;

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

import com.home.education.mountains.common.exception.LocationValidationFailedException;
import com.home.education.mountains.common.exception.ResourceException;
import com.home.education.mountains.resource.impl.Location;
import com.home.education.mountains.service.LocationService;

@Controller
@RequestMapping("/location")
public class LocationController {

	private static final Logger log = LoggerFactory.getLogger(LocationController.class);

	@Autowired
	private LocationService locationService;

	@RequestMapping(value = "/{locationId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Location getById(final @PathVariable int locationId) throws ResourceException {
		log.info("get Location by Id");
		Location location = locationService.getById(locationId);
		return location;
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Collection<Location> getByMountainRange(
			@RequestParam(value = "mountainRange", required = false) final String mountainRange,
			@RequestParam(value = "country", required = false) final String country)
					throws LocationValidationFailedException {
		log.info("get Locations by mountainRange");
		return locationService.getAllFiltered(mountainRange, country);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Location create(@RequestBody final @Valid Location location) throws ResourceException {
		log.info("create Location");
		return locationService.create(location);
	}

	@RequestMapping(value = "/{locationId}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Location modify(@RequestBody final @Valid Location location, final @PathVariable int locationId)
			throws ResourceException {
		log.info("modify Location");
		location.setId(locationId);
		location.getMountains().stream().forEach(m -> m.setLocationId(locationId));
		return locationService.update(location);
	}
	//
	// @RequestMapping(method = RequestMethod.DELETE)
	// @ResponseStatus(HttpStatus.OK)
	// @ResponseBody
	// public Location delete(@RequestBody final @Valid Location location)
	// throws ResourceException{
	// log.info("delete Location");
	// return locationService.delete(location);
	// }
}
