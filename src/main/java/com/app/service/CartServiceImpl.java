package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CartDao;
import com.app.dto.CartItemDto;

@Service
@Transactional
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDao cartDao;
	
	@Override
	public boolean addItemsToUserCart(List<CartItemDto> cartDto, Long userId) {
		
		return false;
	}

}
