package com.home.education.mountains.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.education.mountains.dao.CategoryDao;
import com.home.education.mountains.resource.impl.Category;
import com.home.education.mountains.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl extends ReadGenericServiceImpl<Category, CategoryDao> implements CategoryService {

	@Autowired
	public CategoryServiceImpl(CategoryDao dao) {
		super(dao);
	}

	@Override
	public Category getByName(String routeName) {
		// TODO Auto-generated method stub
		return null;
	}

}
