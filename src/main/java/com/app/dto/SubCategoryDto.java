package com.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SubCategoryDto {
    private Integer id;
    private String categoryName;
    private String description;
    private String image;
    private int rating;
    private double price;
    private int isVisible;
    private LocalDate lastUpdated;
}
