package com.app.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/{userId}")
	@Operation(summary = "get booking details")
	public ResponseEntity<?> getUserBookings(@PathVariable Long userId ){
		System.out.println("get orders for user "+userId);
		return ResponseEntity.status(HttpStatus.FOUND).body(bookingService.getAllBookings(userId));
	}
	
	@DeleteMapping("/deleteBooking/{id}")
	@Operation(summary = "delete bookings")
	public ResponseEntity<?> deleteBooking(@PathVariable Long id)
	{
		return ResponseEntity.ok().body(bookingService.deleteBooking(id));
	}
	
	@GetMapping("/book")
	@Operation(summary = "book service")
	public ResponseEntity<?> bookService(@RequestParam Long id,@RequestParam Long uid,@RequestParam String date,String time)
	{
		System.out.println(date+" "+time);
		LocalDate date2 = LocalDate.parse(date);
		LocalTime time2 = LocalTime.parse(time);
		System.out.println(date2+" "+time2);
		return ResponseEntity.ok().body(bookingService.addBooking(id, uid, date2, time2));
	}
}
