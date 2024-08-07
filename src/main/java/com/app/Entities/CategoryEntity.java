	package com.app.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "category")
public class CategoryEntity {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 @Column(length = 25, nullable = false)
	 private String name;
	 @Column(length = 255)
	 private String description;
	 private String imageUrl;
	 @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
	 private List<SubCategoryEntity> subCategories;
}
