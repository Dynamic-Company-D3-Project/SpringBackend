package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDto;
import com.app.dto.UserLoginDto;
import com.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {	

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<?> userRegistration(@RequestBody @Valid UserDto userDto){
		
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.addNewUser(userDto));	
	}
	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody @Valid UserLoginDto userLoginDto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(userService.loginUser(userLoginDto));
	}
}
