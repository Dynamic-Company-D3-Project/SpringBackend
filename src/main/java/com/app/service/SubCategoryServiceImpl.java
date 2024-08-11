package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entities.SubCategoryEntity;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.SubCategoryDao;
import com.app.dto.SubCategoryDto;

@Service
@Transactional
public class SubCategoryServiceImpl implements SubCategoryService {
	@Autowired
	private SubCategoryDao subCategoryDao;
	
	@Autowired
    private ModelMapper mapper;
	@Override
	public SubCategoryDto getSubCategoryById(Long id) {
		SubCategoryEntity subCategoryEntity= subCategoryDao.findById(id).orElseThrow(()->new ResourceNotFoundException("SubCategory not found"));
		SubCategoryDto subCategoryDto= mapper.map(subCategoryEntity, SubCategoryDto.class);
		return subCategoryDto;
	}
	
	@Override
	public SubCategoryDto getSubCategoryByName(String subName) {
		SubCategoryEntity subCategoryEntity = subCategoryDao.findByCategoryName(subName).orElseThrow(()->new ResourceNotFoundException("Subcategory Not found"));
		SubCategoryDto subCategoryDto=mapper.map(subCategoryEntity, SubCategoryDto.class);
		return subCategoryDto;
	}
 
}
