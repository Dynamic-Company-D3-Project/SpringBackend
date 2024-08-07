package com.app.service;

import java.util.List;

import com.app.Entities.ReviewsEntity;
import com.app.dto.ReviewsDto;

public interface ReviewsService {
List<ReviewsDto> getReviews(Long subcatId);
ReviewsEntity addReview(ReviewsEntity review, Long subcatId);
}
