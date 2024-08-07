package com.app.service;

import com.app.dto.SubCategoryDto;

public interface SubCategoryService {
SubCategoryDto getSubCategoryById(Long id);
SubCategoryDto getSubCategoryByName(String subName);
}
