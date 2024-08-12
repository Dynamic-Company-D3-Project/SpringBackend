//package com.app.Entities;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//import Helpers.Status;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//
//@Entity
//@Data
//@Table(name = "user_support")
//public class UserSupportEntity {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int supportId;
//	@JoinColumn(name = "userId")
//	@ManyToOne
//	private UserEntity user;
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "bookingId")
//	private BookingEntity booking;
//	private Status status;
//	@Column(length = 255, nullable = false)
//	private String description;
//	@Column(length = 50, nullable =  false)
//	private String title;
//}
