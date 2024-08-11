package com.app.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.app.Entities.AddressEntity;
import com.app.Entities.UserEntity;
import com.app.Jwt.JwtResponse;
import com.app.dto.AddressDto;
import com.app.dto.UserDto;
import com.app.dto.UserLoginDto;
import com.app.dto.UserPostDto;

public interface UserService {
	UserDto addNewUser(UserDto userDto);
	JwtResponse loginUser(UserLoginDto userLoginDto);
	String updatePassword(String email,String newPassword);
	UserPostDto updateUser(UserPostDto newUser,String token);
	AddressDto addAddress(AddressDto addressDto, Long id);
}
