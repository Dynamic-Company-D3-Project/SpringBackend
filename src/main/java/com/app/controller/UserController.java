package com.app.controller;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.Entities.AddressEntity;
import com.app.dto.AddressDto;
import com.app.dto.UserDto;
import com.app.dto.UserLoginDto;
import com.app.dto.UserPostDto;
import com.app.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/user")
public class UserController {	

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	@Operation(summary = "register user")
	public ResponseEntity<?> userRegistration(@RequestBody @Valid UserDto userDto){
		
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.addNewUser(userDto));	
	}
	@PostMapping("/login")
	@Operation(summary = "login user")
	public ResponseEntity<?> userLogin(@RequestBody @Valid UserLoginDto userLoginDto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(userService.loginUser(userLoginDto));
	}
	
	@PutMapping("/forgetPassword")
	@Operation(summary = "forget password")
	public ResponseEntity<?> forgotPassword(@RequestParam @Email String email,@RequestParam @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{4,12}$",
		    message = "password must be min 4 and max 12 length containing atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ") String newPassword)
	{
		return ResponseEntity.ok().body(userService.updatePassword(email, newPassword));
	}
	
	@PutMapping("/updateUser/{id}")
	@Operation(summary = "update User")
	public ResponseEntity<?> updateUser(@RequestBody @Valid UserPostDto newUser,@PathVariable Long id)
	{
		return ResponseEntity.ok().body(userService.updateUser(newUser, id));
	}
	@PostMapping("/address/{id}")
	@Operation(summary = "add address of user")
	public ResponseEntity<?> addAddress(@RequestBody AddressDto addressDto, @PathVariable Long id){
		return ResponseEntity.ok().body(userService.addAddress(addressDto, id));
	}
	
}
