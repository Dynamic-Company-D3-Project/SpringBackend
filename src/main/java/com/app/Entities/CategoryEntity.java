package com.app.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter

public class CategoryEntity {
 @Id
 private Long id;
 private String name;
 @Column(name = "description", columnDefinition = "TEXT")
 private String description;
 private String imageUrl;
 
 @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoryEntity", cascade = CascadeType.ALL)
 private List<SubCategory> subCategoryList;
 
 
}
