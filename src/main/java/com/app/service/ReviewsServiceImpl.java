package com.app.service;

import java.util.ArrayList;
import java.util.List;

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
		System.out.println("get Reviews "+ subcatId);
		SubCategoryEntity sub = subDao.findById(subcatId)
				.orElseThrow(()->new ResourceNotFoundException("subcategory not found"));
		List<ReviewsEntity> reviewList = reviewDao.findBySubCategory(sub);
		//reviewList.forEach(System.out::println);
		List<ReviewsDto> reviewDtoList= new ArrayList<ReviewsDto>();
		
	
		reviewList.forEach((review)->{
			reviewDtoList.add(mapper.map(review, ReviewsDto.class));
		});
		return reviewDtoList;
		//return reviewDtoList;
	}

	@Override
	public ReviewsEntity addReview(ReviewsEntity review, Long subcatId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
