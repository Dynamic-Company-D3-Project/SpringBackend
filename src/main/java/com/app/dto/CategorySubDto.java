package com.app.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategorySubDto {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private List<SubCategoryDto> subCategories; // Use SubCategoryDto here
}
