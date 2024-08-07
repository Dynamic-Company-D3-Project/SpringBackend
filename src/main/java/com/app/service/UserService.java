package com.app.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.app.Entities.UserEntity;
import com.app.dto.UserDto;
import com.app.dto.UserLoginDto;
import com.app.dto.UserPostDto;

public interface UserService {
UserDto addNewUser(UserDto userDto);
UserDto loginUser(UserLoginDto userLoginDto);
String updatePassword(String email,String newPassword);
UserPostDto updateUser(UserPostDto newUser,Long id);
}
