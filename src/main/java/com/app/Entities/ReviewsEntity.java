package com.app.Entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Data
public class ReviewsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reviewId;
	@JoinColumn(name = "userId")
	private User user;
	@JoinColumn(name = "subCategoryId")
	private SubCategoryEntity subCategory;
	private int rating;
	@Lob
	private String reivew;
	@CreationTimestamp
	private LocalDate reviewDate;
	@JoinColumn(name = "orderId")
	private OrderEntity order;
}
