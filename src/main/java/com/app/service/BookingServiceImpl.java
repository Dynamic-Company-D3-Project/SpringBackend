package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.Entities.BookingEntity;
import com.app.Entities.OrdersEntity;
import com.app.Entities.UserEntity;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.BookingDao;
import com.app.dao.OrdersDao;
import com.app.dao.UserDao;
import com.app.dto.BookingDto;
import com.app.dto.OrdersDto;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper mapper;
	@Override
	public List<BookingDto> getAllBookings(Long userId) {
		System.out.println("getAllBookings "+ userId);
		UserEntity user = userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid User Id !!!!"));
		System.out.println(user);
		
		List<BookingEntity> bookings = bookingDao.findByUserId(user);
		bookings.forEach(System.out::println);
		
		List<BookingDto> bookingDto = new ArrayList<BookingDto>();
		bookings
		.forEach((order)->{ BookingDto dto = new BookingDto();
		dto.setBookingId(order.getBookingId());
		dto.setSubcategoryName(order.getSubcategory_id().getCategoryName());
		dto.setProviderName(order.getProvider_id().getFirstName()+" "+order.getProvider_id().getLastName());
		dto.setDate(order.getDate());
		dto.setRate(order.getSubcategory_id().getPrice());
		dto.setTime(order.getTime());
		dto.setStatus(order.getStatus());
		bookingDto.add(dto);
		});
		return bookingDto;
	}
	@Override
	public String deleteBooking(Long id) {
		BookingEntity bookingEntity= bookingDao.findById(id).orElseThrow(()->new ResourceNotFoundException("booking not found"));
		bookingDao.delete(bookingEntity);
		return "booking deleted successfully";
	}

}
