package com.app.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.app.Entities.UserEntity;
import com.app.dto.UserDto;
import com.app.dto.UserLoginDto;

public interface UserService {
UserDto addNewUser(UserDto userDto);
UserDto loginUser(UserLoginDto userLoginDto);
}
