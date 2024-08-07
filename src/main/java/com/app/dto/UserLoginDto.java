package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserLoginDto {
	@Email
	@NotBlank(message = "email cannot be blank")
	private String email;
	@NotBlank(message = "password cannot be blank")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
}
