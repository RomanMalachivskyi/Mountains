package com.home.education.mountains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.home.education.mountains.resource.impl.Mountain;
import com.home.education.mountains.service.MountainService;

@Controller
@RequestMapping("/")
public class MountainController {
private static final Logger log = LoggerFactory.getLogger(LocationController.class);
	
	@Autowired
	private MountainService mountainService; 

	@RequestMapping(value= "/{mountainId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Mountain getById(final @PathVariable int mountainId){
		log.info("get Mountain by Id");
		Mountain mountain = mountainService.getById(mountainId);
		return mountain;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Mountain create(@RequestBody final Mountain mountain){
		log.info("create Location");
		return mountainService.create(mountain);
	}
}
