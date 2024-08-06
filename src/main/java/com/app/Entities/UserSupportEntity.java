package com.app.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Data
public class UserSupportEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supportId;
	@JoinColumn(name = "userId")
	private User user;
	@JoinColumn(name = "bookingId")
	private Booking booking;
	private Status status;
	@Column(length = 255, nullable = false)
	private String description;
	@Column(length = 50, nullable =  false)
	private String title;
}
