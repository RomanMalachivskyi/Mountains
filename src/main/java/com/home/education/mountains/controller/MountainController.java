package com.home.education.mountains.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.home.education.mountains.common.exception.ResourceException;
import com.home.education.mountains.resource.impl.Mountain;
import com.home.education.mountains.service.MountainService;

@Controller
@RequestMapping("/mountain")
public class MountainController {
	private static final Logger log = LoggerFactory.getLogger(MountainController.class);
	
	@Autowired
	private MountainService mountainService; 

	@RequestMapping(value= "/{mountainId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Mountain getById(final @PathVariable int mountainId) throws ResourceException{
		log.info("get Mountain by Id");
		Mountain mountain = mountainService.getById(mountainId);
		return mountain;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Mountain create(@Valid @RequestBody final Mountain mountain) throws ResourceException{
		log.info("create Mountain");
		return mountainService.create(mountain);
	}
	
	@RequestMapping(value= "/{mountainId}",method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Mountain modify(@Valid @RequestBody final Mountain mountain, final @PathVariable int mountainId) throws ResourceException{
		log.info("update Mountain");
		mountain.setId(mountainId);
		return mountainService.update(mountain);
	}
	
	@RequestMapping(value= "/{mountainId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Mountain delete(final @PathVariable int mountainId) throws ResourceException{
		log.info("delete Mountain by Id");
		return mountainService.delete(mountainService.getById(mountainId));
	}
}