package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.Entities.*;
import com.app.dto.CategoryDto;
import com.app.dto.CategorySubDto;
import com.app.dto.SubCategoryDto;

public interface CategoryService {
List<CategoryDto> getAllCategories();
List<CategorySubDto> getAllCategoryWithSubCategory();
CategorySubDto getSubCategoryById(Long id);
CategorySubDto getSubCategoryByName(String categoryName);
}
