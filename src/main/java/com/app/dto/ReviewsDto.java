package com.app.dto;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.app.Entities.OrdersEntity;
import com.app.Entities.SubCategoryEntity;
import com.app.Entities.UserEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
public class ReviewsDto {

	@JsonProperty(access = Access.READ_ONLY)
	private Long reviewId;

	private UserEntity user;
	
	private int rating;
	
	private String reivew;

	private LocalDate reviewDate;




}
