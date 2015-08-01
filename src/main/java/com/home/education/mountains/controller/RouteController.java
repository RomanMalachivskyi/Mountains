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
import com.home.education.mountains.resource.impl.Route;
import com.home.education.mountains.service.RouteService;

@Controller
@RequestMapping("/route")
public class RouteController {

	private static final Logger log = LoggerFactory.getLogger(RouteController.class);
	
	@Autowired
	private RouteService routeService; 

	@RequestMapping(value= "/{mountainId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Route getById(final @PathVariable int routeId) throws ResourceException{
		log.info("get Route by Id");
		Route mountain = routeService.getById(routeId);
		return mountain;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Route create(@Valid @RequestBody final Route route){
		log.info("create Route");
		return routeService.create(route);
	}
}
