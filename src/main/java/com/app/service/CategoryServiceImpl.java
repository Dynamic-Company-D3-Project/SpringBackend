package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entities.CategoryEntity;
import com.app.custom_exceptions.ApiException;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.CategoryDao;
import com.app.dao.SubCategoryDao;
import com.app.dto.CategoryDto;
import com.app.dto.CategorySubDto;
import com.app.dto.SubCategoryDto;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	@Autowired
    private CategoryDao categoryDao;
	@Autowired
	private SubCategoryDao subCategoryDao;
	@Autowired
	private ModelMapper mapper;
	@Override
	public List<CategoryDto> getAllCategories() {
		List<CategoryEntity> categoryEntities = categoryDao.findAll();
		List<CategoryDto> categoryDtos= new ArrayList<CategoryDto>();
		for (CategoryEntity categoryEntity : categoryEntities) {
			categoryDtos.add(mapper.map(categoryEntity, CategoryDto.class));
		}
		return categoryDtos;
	}
	@Override
	public List<CategorySubDto> getAllCategoryWithSubCategory() {
        List<CategoryEntity> categoryEntities = categoryDao.findAll();
        return categoryEntities.stream()
            .map(entity -> {
                CategorySubDto dto = mapper.map(entity, CategorySubDto.class);
                dto.setSubCategories(
                    entity.getSubCategories().stream()
                        .map(subEntity -> mapper.map(subEntity, SubCategoryDto.class))
                        .collect(Collectors.toList())
                );
                return dto;
            })
            .collect(Collectors.toList());
    }
	@Override
	public CategorySubDto getSubCategoryById(Long id) {
		return  mapper.map(categoryDao.listofCategoryWithSub(id),CategorySubDto.class);	
	}
	
	@Override
	public CategorySubDto getSubCategoryByName(String categoryName) {
		CategoryEntity categoryEntity = categoryDao.listofCategoryWithSubFindByName(categoryName).orElseThrow(()-> new ResourceNotFoundException("category name not found"));
		CategorySubDto categorySubDto = mapper.map(categoryEntity,CategorySubDto.class);
		return categorySubDto;
	}
}
