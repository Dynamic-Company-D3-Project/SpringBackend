package com.app.Entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Data
@Table(name = "reviews")
@ToString
public class ReviewsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reviewId;
	@OneToOne
	@JoinColumn(name = "userId")
	private UserEntity user;
	@ManyToOne
	@JoinColumn(name = "subCategoryId")
	private SubCategoryEntity subCategory;
	private int rating;
	@Lob
	private String reivew;
	@CreationTimestamp
	private LocalDate reviewDate;	
}
