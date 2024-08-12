package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.app.Entities.AddressEntity;
import com.app.Entities.UserEntity;
import com.app.Jwt.JwtResponse;
import com.app.dto.AddressDto;
import com.app.dto.AddressPostDto;
import com.app.dto.UserDto;
import com.app.dto.UserLoginDto;
import com.app.dto.UserPostDto;

import Helpers.AddressTypeEnum;

public interface UserService {
	UserDto addNewUser(UserDto userDto);
	JwtResponse loginUser(UserLoginDto userLoginDto);
	String updatePassword(String email,String newPassword);
	UserPostDto updateUser(UserPostDto newUser,String token);
	AddressDto addAddress(AddressDto addressDto, String token);
	List<AddressDto> getAddress(String token);
	AddressDto getSingleAddress(String token,AddressTypeEnum aEnum);
	String updateAddress(String token,AddressPostDto aDto);
	String getHomeAddressString(String token);
	UserDto getUserDetails(String token);
}
