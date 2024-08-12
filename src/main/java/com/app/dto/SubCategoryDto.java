package com.app.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
