package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/catgeory")
public class CategoryController {
@Autowired
private CategoryService categoryService;

@GetMapping("/categoryList")
@Operation(summary = "get only Category Details")
public ResponseEntity<?> getListOfCategory()
{
	return ResponseEntity.ok().body(categoryService.getAllCategories());
}

@GetMapping("/categoryListWithSubcategory")
@Operation(summary = "get Category along with Subcategory Details")
public ResponseEntity<?> getListOfCategoryWithSubCategory()
{
	return ResponseEntity.ok().body(categoryService.getAllCategoryWithSubCategory());
}

@GetMapping("/categoryWithSubCategoryList/{id}")
@Operation(summary = "get Category with list of Subcategory")
public ResponseEntity<?> getCategoryWithSubcategories(@PathVariable Long id)
{
	return ResponseEntity.status(HttpStatus.OK).body(categoryService.getSubCategoryById(id));
}

@GetMapping("/categoryWithSubCategoryListByName")
@Operation(summary = "get Category with list of Subcategory find by Name")
public ResponseEntity<?> getCategoryWithSubByName(@RequestParam String categoryName)
{
	return ResponseEntity.ok().body(categoryService.getSubCategoryByName(categoryName));
}

}
