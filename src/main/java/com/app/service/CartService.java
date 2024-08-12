package com.app.service;

import java.net.URI;
import java.util.List;

import com.app.dto.CartItemDto;

public interface CartService {

	boolean addItemsToUserCart(List<CartItemDto> cartDto, Long userId);

}
