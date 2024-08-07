package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entities.CategoryEntity;
import com.app.dao.CategoryDao;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Autowired
    private CategoryDao categoryDao;
	@Override
	public List<CategoryEntity> getAllCategories() {
		return categoryDao.findAll();
	}
}
