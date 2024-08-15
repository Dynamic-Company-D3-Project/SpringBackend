package com.app.dto;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import Helpers.AddressTypeEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartItemDto {
	@JsonProperty(access = Access.READ_ONLY)
	 private Long id;
	 
	 @JsonProperty(access=Access.READ_ONLY)
	 private String name;
	 
	 @JsonProperty(access = Access.READ_ONLY)
	 private String description;
	 
	 @JsonProperty(access=Access.READ_ONLY)
	 private String image;
	       
	 @JsonProperty(access=Access.READ_ONLY)
	 private double price;
	 
	 @JsonProperty(access = Access.WRITE_ONLY)
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 private String date;
	 
	 @JsonProperty(access = Access.WRITE_ONLY)
	 @DateTimeFormat(pattern = "HH:mm")
	 private String time;
	 
	 @JsonProperty(access = Access.WRITE_ONLY)
	 private AddressTypeEnum addressType;
}
