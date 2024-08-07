package com.app.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entities.ReviewsEntity;
import com.app.Entities.SubCategoryEntity;
public interface ReviewsDao extends JpaRepository<ReviewsEntity, Long> {
	List<ReviewsEntity> findBySubCategory(SubCategoryEntity sub);
}
