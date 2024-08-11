package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.Entities.AddressEntity;
import com.app.Entities.UserEntity;
import com.app.custom_exceptions.ApiException;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.AddressDao;
import com.app.dao.UserDao;
import com.app.dto.AddressDto;
import com.app.dto.UserDto;
import com.app.dto.UserLoginDto;
import com.app.dto.UserPostDto;

@Service
@Transactional
public class UserServiceImpl implements UserService {
@Autowired
private UserDao userDao;
@Autowired
private AddressDao addressDao;
@Autowired
private ModelMapper modelMapper;
 private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

@Override
public UserDto addNewUser(UserDto userDto) {
	if(userDto.getPassword().equals(userDto.getConfirmPassword()))
	{
		UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);
		userEntity.setPassword(encoder.encode(userEntity.getPassword()));
		UserEntity savedUser =  userDao.save(userEntity);
		return modelMapper.map(savedUser, UserDto.class);
	}
	throw new ApiException("Password does matched");
}


@Override
public UserDto loginUser(UserLoginDto userLoginDto) {
    UserEntity user = userDao.findByEmail(userLoginDto.getEmail())
        .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    if (!encoder.matches(userLoginDto.getPassword(), user.getPassword())) {
        throw new ApiException("Invalid credentials");
    }
    return modelMapper.map(user, UserDto.class);
}

@Override
public String updatePassword(String email, String newPassword) {
	UserEntity userEntity=userDao.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("email does not match"));
	userEntity.setPassword(encoder.encode(newPassword));
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


@Override
public AddressDto addAddress(AddressDto addressDto, Long id) {
	UserEntity entity = userDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found"));
	if(entity != null) {
		AddressEntity addressEntity = modelMapper.map(addressDto, AddressEntity.class);
		addressEntity.setUser(entity);
		addressDao.save(addressEntity);
		return addressDto;
	}
	return null;
  }
}
