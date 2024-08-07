package com.app.dto;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoryDto {
	 private Long id;
	 private String name;
	 private String description;
	 private String imageUrl;

}
