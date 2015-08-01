package com.home.education.mountains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.home.education.mountains.common.exception.ResourceException;
import com.home.education.mountains.resource.impl.Category;
import com.home.education.mountains.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	private static final Logger log = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Category getById(final @PathVariable int categoryId) throws ResourceException {
		log.info("get Location by Id");
		Category category = categoryService.getById(categoryId);
		return category;
	}
}
