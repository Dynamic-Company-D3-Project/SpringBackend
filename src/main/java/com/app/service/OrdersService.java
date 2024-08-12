package com.app.service;

import java.util.List;

import com.app.dto.OrdersDto;

public interface OrdersService {

	List<OrdersDto> getAllOrders(String token);

}
