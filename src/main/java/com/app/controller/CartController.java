package com.app.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.app.dto.CartItemDto;
import com.app.service.CartService;



@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/")
	public ResponseEntity<?> getUserCart(@RequestHeader("Authorization") String authHeader){
		String token = authHeader.substring(7);
		return ResponseEntity.ok().body(cartService.getCartItems(token));
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/{id}")
	public ResponseEntity<?> addItemsToCart(@RequestHeader("Authorization") String authHeader, @PathVariable Long id){
		String token = authHeader.substring(7);
		return ResponseEntity.ok().body(cartService.addCartitems(token,id));
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBooking(@RequestHeader("Authorization") String authHeader, @PathVariable Long id)
	{
		String token = authHeader.substring(7);
		return ResponseEntity.ok().body(cartService.deleteCartItems(token, id));
	}
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/")
	public ResponseEntity<?> bookService(@RequestBody CartItemDto cartItemDto,@RequestHeader("Authorization") String authHeader)
	{
		String token = authHeader.substring(7);
		return ResponseEntity.ok().body(cartService.bookCart(cartItemDto, token));
	}

}
