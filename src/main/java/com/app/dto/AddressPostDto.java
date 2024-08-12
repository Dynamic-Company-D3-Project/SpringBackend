package com.app.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import Helpers.AddressTypeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddressPostDto {
	@NotBlank(message = "street cannot be blank")
	 private String street;
	@NotNull(message = "addressType cannot be blank")
	 private AddressTypeEnum addressType;
	@NotNull(message = "pincode cannot be blank")
	 private Long pincode;
	@NotNull(message = "pincode cannot be blank")
	 private Long houseNo;
	@NotBlank(message = "state cannot be blank")
	 private String state; 
	@NotBlank(message = "country cannot be blank")
	 private String country;
	@NotBlank(message = "city cannot be blank")
	 private String city;
}
