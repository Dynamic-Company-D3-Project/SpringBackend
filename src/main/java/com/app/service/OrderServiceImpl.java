package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.Entities.OrdersEntity;
import com.app.Entities.UserEntity;
import com.app.dao.OrdersDao;
import com.app.dao.UserDao;
import com.app.dto.OrdersDto;
import com.app.custom_exceptions.ResourceNotFoundException;

@Service
@Transactional
public class OrderServiceImpl implements OrdersService {
	
	@Autowired
	private OrdersDao orderDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<OrdersDto> getAllOrders(Long userId) {
		System.out.println("getAllOrders "+ userId);
		UserEntity user = userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid User Id !!!!"));
		System.out.println(user);
		
		List<OrdersEntity> orders = orderDao.findByUserId(user);
		orders.forEach(System.out::println);
		
		List<OrdersDto> orderDto = new ArrayList<OrdersDto>();
		orders
		.forEach((order)->{ OrdersDto dto = new OrdersDto();
		dto.setOrderId(order.getOrderId());
		dto.setSubcategory_id(order.getSubcategory_id().getCategoryName());
		dto.setProvider_id(order.getProvider_id().getFirstName()+" "+order.getProvider_id().getLastName());
		dto.setDate(order.getDate());
		dto.setDescription(order.getDescription());
		dto.setRate(order.getRate());
		dto.setTime(order.getTime());
		dto.setStatus(order.getStatus());
		orderDto.add(dto);
		});
		
		
		
		return orderDto;
	}

}
