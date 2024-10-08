package com.app.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import Helpers.AddressTypeEnum;

import lombok.*;


@Data
@Entity
@Table(name = "address")
public class AddressEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long addressId;	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	 private UserEntity user;
	 private String street;
	 
	 @Enumerated(EnumType.STRING)
	 private AddressTypeEnum addressType;
	 @Column(nullable = false,length = 6)
	 private Long pincode;
	 @Column(name="house_no")
	 private Long houseNo;
	 @Column(nullable = false)
	 private String state; 
	 private String country;
	 private String city;
}
