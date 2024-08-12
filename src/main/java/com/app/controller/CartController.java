package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CartItemDto;
import com.app.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/{userId}")
	public ResponseEntity<?> addItemsToCart(@RequestBody List<CartItemDto> cartDto, @PathVariable Long userId){
		return ResponseEntity.ok(cartService.addItemsToUserCart(cartDto,userId));
	}
}
