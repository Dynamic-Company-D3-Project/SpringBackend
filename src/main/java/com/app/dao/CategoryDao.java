package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.Entities.CategoryEntity;
import com.app.dto.CategorySubDto;

public interface CategoryDao extends JpaRepository<CategoryEntity, Long> {
	@Query("select c from CategoryEntity c left join fetch c.subCategories where c.id=:cId")
	CategoryEntity listofCategoryWithSub(Long cId);
	
	@Query("select c from CategoryEntity c left join fetch c.subCategories where c.name=:cName")
	Optional<CategoryEntity> listofCategoryWithSubFindByName(String cName);
}
