package com.app.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entities.CartItemEntity;
import com.app.Entities.SubCategoryEntity;
import com.app.Entities.UserEntity;
import com.app.Security.JwtHelper;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.CartDao;
import com.app.dao.SubCategoryDao;
import com.app.dao.UserDao;
import com.app.dto.BookingPostDto;
import com.app.dto.CartItemDto;

@Service
@Transactional
public class CartServiceImpl implements CartService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private JwtHelper jwtHelper;
	
	@Autowired
	private SubCategoryDao subCategoryDao;
	
	@Autowired
	private BookingService bookingService;
	
	

	@Override
	public List<CartItemDto> getCartItems(String token) {
		Long userId = jwtHelper.getUserIdFromToken(token);
		
		UserEntity user = userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid User Id !!!!"));
		
		List<CartItemEntity> cartItemList = cartDao.findByUserId(user);
		
		
		
		return cartItemList.stream().map(cart -> {
			
		
			return CartItemDto.builder().
					id(cart.getId()).
					description(cart.getSubCategoryId().getDescription()).
					price(cart.getSubCategoryId().getPrice()).
					image(cart.getSubCategoryId().getImage())
					.name(cart.getSubCategoryId().getCategoryName())
					.build();
			

			
		}).collect(Collectors.toList());
		
		
		
		
	}

	@Override
	public String addCartitems(String token, Long id) {
		Long userId = jwtHelper.getUserIdFromToken(token);
		
		UserEntity user = userDao.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("Invalid User Id !!!"));
		
		SubCategoryEntity subCategory = subCategoryDao.findById(id).
				orElseThrow(()-> new ResourceNotFoundException("Invalid Subcategory"));
		
		CartItemEntity cartItem = new CartItemEntity();
		cartItem.setUserId(user);
		cartItem.setSubCategoryId(subCategory);
		
		cartDao.save(cartItem);
		
		return "Cart Item added successfully";
	}

	@Override
	public String deleteCartItems(String token, Long id) {
		
		cartDao.deleteById(id);
		
		return "Cart Item deleted successfully";
	}

	@Override
	public String bookCart(CartItemDto cartItemDto, String token) {
		Long userId = jwtHelper.getUserIdFromToken(token);
		
		UserEntity user = userDao.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("Invalid User Id !!!"));
		
		List<CartItemEntity> cartItemList = cartDao.findByUserId(user); 
		
		cartItemList.stream().forEach((cartItem)->{
			
			
			bookingService.addCartBooking(cartItem.getSubCategoryId().getId(), token, cartItemDto);
			deleteCartItems(token, cartItem.getId());
		});
		
		return "cart added to bookings";
	}

}
