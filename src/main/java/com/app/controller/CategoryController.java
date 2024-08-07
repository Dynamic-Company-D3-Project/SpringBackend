package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.CategoryService;

@RestController
@RequestMapping("/catgeory")
public class CategoryController {
@Autowired
private CategoryService categoryService;

@GetMapping
public ResponseEntity<?> getCategory()
{
	return ResponseEntity.ok().body(categoryService.getAllCategories());
}
}
