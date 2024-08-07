package com.app.Entities;

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

import Helpers.BookingStatus;
import lombok.Data;

@Entity
@Table(name="bookings")
@Data
public class BookingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private UserEntity userId;
	
	@ManyToOne
	@JoinColumn(name="provider_id", nullable=false)
	private ProviderEntity provider_id;
	
	@ManyToOne
	@JoinColumn(name="subcategory_id", nullable=false)
	private SubCategoryEntity subcategory_id;
	
	@Enumerated(EnumType.STRING)
	private BookingStatus status;
	
	@Column(name = "booking_date", nullable = false)
	private LocalDate date;
	@Column(name = "booking_time", nullable = false)
	private LocalTime time;
	
	
}
