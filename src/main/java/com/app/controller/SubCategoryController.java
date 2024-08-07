package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.SubCategoryService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/subCategory")
public class SubCategoryController {
	
@Autowired
private SubCategoryService subCategoryService;

@GetMapping("/subCategoryById/{id}")
@Operation(summary = "get subCategory by id")
public ResponseEntity<?> getSubCategoryById(@PathVariable Long id )
{
	return ResponseEntity.ok().body(subCategoryService.getSubCategoryById(id));
}

@GetMapping("/subCategoryByName")
@Operation(summary = "get subCategory by Name")
public ResponseEntity<?> getSubCategoryByName(@RequestParam String subName)
{
	return ResponseEntity.ok().body(subCategoryService.getSubCategoryByName(subName));
}
}
