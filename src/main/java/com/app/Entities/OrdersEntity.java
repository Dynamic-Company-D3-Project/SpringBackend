package com.app.Entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringExclude;

import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Data
@Table(name = "orders")

public class OrdersEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long orderId;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private UserEntity userId;
	
	@ManyToOne
	@JoinColumn(name="subcategory_id", nullable=false)
	private SubCategoryEntity subcategory_id;
	
	@ManyToOne
	@JoinColumn(name="provider_id", nullable=false)
	private ProviderEntity provider_id;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	private String description;
	@Column(name="order_rate", precision = 10, scale =2 )
	private BigDecimal rate;
	@Column(name = "order_date", nullable = false)
	private LocalDate date;
	@Column(name = "order_time", nullable = false)
	private LocalTime time;
	
}
