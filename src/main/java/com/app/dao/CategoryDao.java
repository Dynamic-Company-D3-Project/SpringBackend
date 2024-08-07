package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.Entities.CategoryEntity;

public interface CategoryDao extends JpaRepository<CategoryEntity, Long> {
	
}
