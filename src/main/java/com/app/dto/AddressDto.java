package com.app.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.app.Entities.UserEntity;

import Helpers.AddressTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AddressDto {
	 private String street;
	 private AddressTypeEnum addressType;
	 private Long pincode;
	 private Long houseNo;
	 private String state; 
	 private String country;
	 private String city;
}
