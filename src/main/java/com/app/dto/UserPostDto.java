package com.app.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import Helpers.Gender;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserPostDto {
	@NotBlank(message = "fisrt name cannot be blank")
	private String firstName;
	@NotBlank(message = "last name cannot be blank")
	private String lastName;
	@Size(min = 10,max=12)
	@NotBlank(message = "phone number cannot be blank")
	private String phoneNumber;
	
	private Gender gender;
	@Min(value = 15)
	private int age;
}
