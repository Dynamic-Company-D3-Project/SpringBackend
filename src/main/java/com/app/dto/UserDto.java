package com.app.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import Helpers.Gender;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class UserDto {
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;
	
	@NotBlank(message = "fisrt name cannot be blank")
	private String firstName;
	@NotBlank(message = "last name cannot be blank")
	private String lastName;
	@NotBlank(message = "password cannot be blank")
	@JsonProperty(access = Access.WRITE_ONLY)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{4,12}$",
    message = "password must be min 4 and max 12 length containing atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
	private String password;
	@NotBlank(message = "confirm password cannot be blank")
	@JsonProperty(access = Access.WRITE_ONLY)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{4,12}$",
    message = "password must be min 4 and max 12 length containing atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
	private String confirmPassword;
	@Email
	private String email;
	@Size(min = 10,max=12)
	@NotBlank(message = "phone number cannot be blank")
	private String phoneNumber;
	
	private Gender gender;
	@Min(value = 15)
	private int age;
	
}
