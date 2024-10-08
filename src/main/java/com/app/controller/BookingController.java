package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.BookingService;
import com.app.service.OrdersService;

@RestController
@RequestMapping("/booking")
@Validated
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/{userId}")
	public ResponseEntity<?> getUserBookings(@PathVariable Long userId ){
		System.out.println("get orders for user "+userId);
		return ResponseEntity.status(HttpStatus.FOUND).body(bookingService.getAllBookings(userId));
	}
}
