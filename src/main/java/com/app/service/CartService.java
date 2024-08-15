package com.app.service;

import java.util.List;

import com.app.dto.CartItemDto;

public interface CartService {

	List<CartItemDto> getCartItems(String token);

	String addCartitems(String token, Long id);

	String deleteCartItems(String token, Long id);
	
	String bookCart(CartItemDto cartItemDto, String token);
	
}
