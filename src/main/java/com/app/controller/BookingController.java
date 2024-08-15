package com.app.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BookingPostDto;
import com.app.service.BookingService;
import com.app.service.OrdersService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/booking")
@Validated
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getBooking")
	@Operation(summary = "get booking details")
	public ResponseEntity<?> getUserBookings(@RequestHeader("Authorization") String authHeader){
		String token = authHeader.substring(7);
		return ResponseEntity.ok().body(bookingService.getAllBookings(token));
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/deleteBooking/{id}")
	@Operation(summary = "delete bookings")
	public ResponseEntity<?> deleteBooking(@PathVariable Long id)
	{
		return ResponseEntity.ok().body(bookingService.deleteBooking(id));
	}
	
	@PostMapping("/book/{id}")
	@CrossOrigin(origins = "http://localhost:3000")
	@Operation(summary = "book service")
	public ResponseEntity<?> bookService(@RequestBody BookingPostDto bookingPostDto,@RequestHeader("Authorization") String authHeader,@PathVariable long id)
	{
		
		String token = authHeader.substring(7);
		return ResponseEntity.ok().body(bookingService.addBooking(id, token, bookingPostDto));
	}
}
