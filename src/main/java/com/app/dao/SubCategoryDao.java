package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.Entities.SubCategoryEntity;

public interface SubCategoryDao extends JpaRepository<SubCategoryEntity, Long> {
	
	Optional<SubCategoryEntity> findByCategoryName(String subName);
}
