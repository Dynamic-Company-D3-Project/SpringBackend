package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.OrdersService;

@RestController
@RequestMapping("/order")
@Validated
public class ProductController {
	
	@Autowired
	private OrdersService orderService;
	
	@GetMapping("/getOrders")
	public ResponseEntity<?> getUserOrders(@RequestHeader("Authorization") String authHeader){
		String token = authHeader.substring(7);
		return ResponseEntity.status(HttpStatus.FOUND).body(orderService.getAllOrders(token));
	}
}
