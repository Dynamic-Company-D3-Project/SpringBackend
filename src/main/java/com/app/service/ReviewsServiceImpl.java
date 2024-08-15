package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entities.ReviewsEntity;
import com.app.Entities.SubCategoryEntity;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.ReviewsDao;
import com.app.dao.SubCategoryDao;
import com.app.dto.ReviewsDto;
import com.app.dto.SubCategoryDto;

@Service
@Transactional
public class ReviewsServiceImpl implements ReviewsService{
	
	@Autowired
	private ReviewsDao reviewDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private SubCategoryDao subDao;

	@Override
	public List<ReviewsDto> getReviews(Long subcatId) {
	    System.out.println("get Reviews " + subcatId);
	    SubCategoryEntity sub = subDao.findById(subcatId)
	            .orElseThrow(() -> new ResourceNotFoundException("subcategory not found"));
	    List<ReviewsEntity> reviewList = reviewDao.findBySubCategory(sub);
	    reviewList.forEach(System.out::println);
	    return reviewList.stream()
	            .map(review -> {
	                ReviewsDto reviewDto = mapper.map(review, ReviewsDto.class);
	                if (review.getSubCategory() != null) {
	                    SubCategoryDto subCategoryDto = mapper.map(review.getSubCategory(), SubCategoryDto.class);
	                    reviewDto.setCategoryEntity(subCategoryDto);
	                }
	                return reviewDto;
	            })
	            .collect(Collectors.toList());
	}

	@Override
	public ReviewsEntity addReview(ReviewsEntity review, Long subcatId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReviewsDto> getAllReviews() {
		List<ReviewsEntity> all = reviewDao.findAll();
		System.out.println(all);
		return all.stream()
				.map(review ->{
					ReviewsDto reviewsDto = mapper.map(review, ReviewsDto.class);
					if (review.getSubCategory() != null) {
	                    SubCategoryDto subCategoryDto = mapper.map(review.getSubCategory(), SubCategoryDto.class);
	                    reviewsDto.setCategoryEntity(subCategoryDto);
	                }
					return reviewsDto;
				}).collect(Collectors.toList());
	}
	
}
