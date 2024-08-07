package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entities.UserEntity;
import com.app.custom_exceptions.ApiException;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.UserDao;
import com.app.dto.UserDto;
import com.app.dto.UserLoginDto;
import com.app.dto.UserPostDto;

@Service
@Transactional
public class UserServiceImpl implements UserService {
@Autowired
private UserDao userDao;

@Autowired
private ModelMapper modelMapper;
@Override
public UserDto addNewUser(UserDto userDto) {
	if(userDto.getPassword().equals(userDto.getConfirmPassword()))
	{
		UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
		UserEntity savedUser =  userDao.save(userEntity);
		return modelMapper.map(savedUser, UserDto.class);
	}
	throw new ApiException("Password does matched");
}
@Override
public UserDto loginUser(UserLoginDto userLoginDto) {
	String emailString = userLoginDto.getEmail();
	String passwordString = userLoginDto.getPassword();
	UserEntity user = userDao.findByEmailAndPassword(emailString, passwordString).orElseThrow(()-> new ResourceNotFoundException("User not found"));
	UserDto userDto = modelMapper.map(user, UserDto.class);
	return userDto;
}
@Override
public String updatePassword(String email, String newPassword) {
	UserEntity userEntity=userDao.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("email does not match"));
	userEntity.setPassword(newPassword);
	if(userDao.save(userEntity)!=null)
	return "password changed successfully";
	else {
	return null;
	}
}
@Override
public UserPostDto updateUser(UserPostDto newUser,Long id) {
	UserEntity userEntity=userDao.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found"));
	userEntity.setFirstName(newUser.getFirstName());
	userEntity.setLastName(newUser.getLastName());
	userEntity.setGender(newUser.getGender());
	userEntity.setAge(newUser.getAge());
	userEntity.setPhoneNumber(newUser.getPhoneNumber());
	
	return modelMapper.map(userDao.save(userEntity), UserPostDto.class);
}
}
