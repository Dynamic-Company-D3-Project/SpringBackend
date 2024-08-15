package com.app.service;

import java.util.List;

import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;

import com.app.dto.OrdersDto;

public interface OrdersService {

	List<OrdersDto> getAllOrders(String token);
}
