package com.app.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;

import com.app.Entities.ProviderEntity;
import com.app.Entities.SubCategoryEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import Helpers.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrdersDto {
	@JsonProperty(access = Access.READ_ONLY)
	private Long orderId;
	private String subcategory_id;
	private String provider_id;
	private OrderStatus status;
	private String description;
	private BigDecimal rate;
	private LocalDate date;
	private LocalTime time;

}
