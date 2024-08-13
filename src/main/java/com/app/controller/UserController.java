package com.app.controller;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.Entities.AddressEntity;
import com.app.Jwt.JwtResponse;
import com.app.Security.JwtHelper;
import com.app.custom_exceptions.ApiException;
import com.app.dto.AddressDto;
import com.app.dto.AddressPostDto;
import com.app.dto.UserDto;
import com.app.dto.UserLoginDto;
import com.app.dto.UserPostDto;
import com.app.service.UserService;

import Helpers.AddressTypeEnum;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {	

	@Autowired
	private UserService userService;
	@Autowired
	private JwtHelper helper;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/register")
	@Operation(summary = "register user")
	public ResponseEntity<?> userRegistration(@RequestBody @Valid UserDto userDto){
		
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.addNewUser(userDto));	
	}
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:3000")
    @Operation(summary = "Login user")
    public ResponseEntity<?> userLogin(@RequestBody @Valid UserLoginDto userLoginDto) {
        try {
            // Call the service layer to authenticate the user and get the JWT response
            JwtResponse jwtResponse = userService.loginUser(userLoginDto);

            // Log the successful login
            logger.info("User {} logged in successfully", userLoginDto.getEmail());

            // Return the JWT token and user information
            return ResponseEntity.status(HttpStatus.OK).body(jwtResponse);
        } catch (ApiException e) {
            // Log the error and return an unauthorized response
            logger.error("Login failed for user {}: {}", userLoginDto.getEmail(), e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        } catch (Exception e) {
            // Log any other errors
            logger.error("Unexpected error during login: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }   
}
    
	
	@PutMapping("/forgetPassword")
	@Operation(summary = "forget password")
	public ResponseEntity<?> forgotPassword(@RequestParam @Email String email,@RequestParam @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{4,12}$",
		    message = "password must be min 4 and max 12 length containing atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ") String newPassword)
	{
		return ResponseEntity.ok().body(userService.updatePassword(email, newPassword));
	}
	
	@GetMapping("/getUser")
	@Operation(summary = "get User")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<?> getUserDetails(@RequestHeader("Authorization") String authHeader)
	{
		String token = authHeader.substring(7);
		return ResponseEntity.ok().body(userService.getUserDetails(token));
	}
	
	@PutMapping("/updateUser")
	@Operation(summary = "update User")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<?> updateUser(@RequestBody @Valid UserPostDto newUser,@RequestHeader("Authorization") String authHeader)
	{
		//System.out.println(authHeader);
		// Extract the token from the Authorization header (removing "Bearer " prefix)
        String token = authHeader.substring(7);
		return ResponseEntity.ok().body(userService.updateUser(newUser, token));
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/address")
	@Operation(summary = "add address of user")
	public ResponseEntity<?> addAddress(@RequestBody AddressDto addressDto, @RequestHeader("Authorization") String authHeader){
		String token = authHeader.substring(7);
		return ResponseEntity.ok().body(userService.addAddress(addressDto, token));
	}
	
<<<<<<< HEAD
	@GetMapping("/getAddress")
	@CrossOrigin(origins = "http://localhost:3000")
=======
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/getAddress")
>>>>>>> 45eb4e20b854df60e4ce4ed6028f1be10debbca4
	@Operation(summary = "get user address Details")
	public ResponseEntity<?> getUserAddress(@RequestHeader("Authorization") String authHeader)
	{
		String token = authHeader.substring(7);
		return ResponseEntity.ok().body(userService.getAddress(token));
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getAddressOnType")
	@CrossOrigin(origins = "http://localhost:3000")
	@Operation(summary = "get user address based on address Type")
	public ResponseEntity<?> getAddressOnType(@RequestHeader("Authorization") String authHeader,@RequestParam AddressTypeEnum aEnum)
	{
		String token = authHeader.substring(7);
		return ResponseEntity.ok().body(userService.getSingleAddress(token, aEnum));
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/updateAddress")
	@CrossOrigin(origins = "http://localhost:3000")
	@Operation(summary = "update user address")
	public ResponseEntity<?> updateAddress(@RequestHeader("Authorization") String authHeader,@RequestBody @Valid AddressPostDto aDto)
	{
		String token = authHeader.substring(7);
		return ResponseEntity.ok().body(userService.updateAddress(token, aDto));
	}
	
	@GetMapping("/getHomeAddressString")
	@CrossOrigin(origins = "http://localhost:3000")
	@Operation(summary = "get home address String of user")
	public ResponseEntity<?> getHomeAddressString(@RequestHeader("Authorization") String authHeader)
	{
		String token = authHeader.substring(7);
		return ResponseEntity.ok().body(userService.getHomeAddressString(token));	
	}
}
