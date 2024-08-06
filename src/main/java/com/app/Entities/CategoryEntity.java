package com.app.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CategoryEntity {
@Id
 private Long id;
 private String name;
 private String description;
 private String imageUrl;
}
