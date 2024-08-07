package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.ReviewsService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
	@Autowired
	private ReviewsService reviewService;
	
	@GetMapping("/{subCatId}")
	public ResponseEntity<?> getReviewsBySubCat(@PathVariable Long subCatId){
		System.out.println("get review "+subCatId);
		return ResponseEntity.ok().body(reviewService.getReviews(subCatId));
	}
}
