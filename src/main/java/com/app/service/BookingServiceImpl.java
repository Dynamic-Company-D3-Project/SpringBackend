package com.app.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.Entities.AddressEntity;
import com.app.Entities.BookingEntity;
import com.app.Entities.OrdersEntity;
import com.app.Entities.SubCategoryEntity;
import com.app.Entities.UserEntity;
import com.app.Security.JwtHelper;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.AddressDao;
import com.app.dao.BookingDao;
import com.app.dao.OrdersDao;
import com.app.dao.SubCategoryDao;
import com.app.dao.UserDao;
import com.app.dto.BookingDto;
import com.app.dto.BookingPostDto;
import com.app.dto.CartItemDto;
import com.app.dto.OrdersDto;
import com.app.dto.SubCategoryDto;

import Helpers.BookingStatus;
import Helpers.OrderStatus;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SubCategoryDao subDao;
	
	@Autowired
	private JwtHelper jwtHelper;
	
	@Autowired
	private OrdersDao oDao;
	
//	@Autowired
//	private ProviderSupportDao pDao;
	
	@Autowired
	private AddressDao addressDao;
	
	@Autowired
	private ModelMapper mapper;
	@Override
	public List<BookingDto> getAllBookings(String token) {
		Long userId = jwtHelper.getUserIdFromToken(token);
		UserEntity user = userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid User Id !!!!"));
		
		List<BookingEntity> bookings = bookingDao.findByUserId(user);
		
		List<BookingDto> bookingDto = new ArrayList<BookingDto>();
		bookings
		.forEach((order)->{ BookingDto dto = new BookingDto();
		dto.setBookingId(order.getBookingId());
		dto.setSubcategoryName(order.getSubcategory_id().getCategoryName()); 
		dto.setProvider_id(order.getProvider_id());
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
//        List<ProviderSupportEntity> pList = new ArrayList<ProviderSupportEntity>(pDao.findByBooking(id));
//        if(!pList.isEmpty())
//        {
//        pList.forEach((support)-> pDao.delete(support));
//        }
		if(bookingEntity.getStatus()==BookingStatus.ASSIGNED)
		{
		OrdersEntity ordersEntity = new OrdersEntity();
		ordersEntity.setDate(bookingEntity.getDate());
		ordersEntity.setTime(bookingEntity.getTime());
		ordersEntity.setDescription(bookingEntity.getSubcategory_id().getDescription());
		ordersEntity.setProvider_id(bookingEntity.getProvider_id());
		ordersEntity.setRate(bookingEntity.getSubcategory_id().getPrice());
		ordersEntity.setSubcategory_id(bookingEntity.getSubcategory_id());
		ordersEntity.setUserId(bookingEntity.getUserId());
		ordersEntity.setStatus(OrderStatus.CANCELLED);
	    oDao.save(ordersEntity);
		}
		bookingDao.delete(bookingEntity);
		return "booking deleted successfully";
	}
	@Override
	public String addBooking(Long id, String token, BookingPostDto bookingPostDto) {
		Long uid = jwtHelper.getUserIdFromToken(token);
		System.out.println(bookingPostDto);
		LocalDate date = LocalDate.parse(bookingPostDto.getDate());
		LocalTime time = LocalTime.parse(bookingPostDto.getTime());
		if(subDao.existsById(id))
		{
			SubCategoryEntity subCategoryEntity = subDao.findById(id).orElseThrow(()->new ResourceNotFoundException("sub category not found"));
			UserEntity userEntity = userDao.findById(uid).orElseThrow(()->new ResourceNotFoundException("user not found"));
			System.out.println(userEntity+" "+bookingPostDto.getAddressType());
			AddressEntity addressEntity = addressDao.findByUserAndAddressType(userEntity, bookingPostDto.getAddressType()); 
			System.out.println(addressEntity);
			BookingEntity bookingEntity= new BookingEntity();
			bookingEntity.setDate(date);
			bookingEntity.setTime(time);
			bookingEntity.setSubcategory_id(subCategoryEntity);
			bookingEntity.setUserId(userEntity);
			bookingEntity.setStatus(BookingStatus.PENDING);
			bookingEntity.setAddressId(addressEntity);
			bookingDao.save(bookingEntity);
			return "booking completed";
		}
		else
		return "booking failed";
	}
	@Override
	public String addCartBooking(Long id, String token, CartItemDto cartItemDto) {
		Long uid = jwtHelper.getUserIdFromToken(token);
		LocalDate date = LocalDate.parse(cartItemDto.getDate());
		LocalTime time = LocalTime.parse(cartItemDto.getTime());
		if(subDao.existsById(id))
		{
			SubCategoryEntity subCategoryEntity = subDao.findById(id).orElseThrow(()->new ResourceNotFoundException("sub category not found"));
			UserEntity userEntity = userDao.findById(uid).orElseThrow(()->new ResourceNotFoundException("user not found"));
			AddressEntity addressEntity = addressDao.findByUserAndAddressType(userEntity, cartItemDto.getAddressType()); 
			BookingEntity bookingEntity= new BookingEntity();
			bookingEntity.setDate(date);
			bookingEntity.setTime(time);
			bookingEntity.setSubcategory_id(subCategoryEntity);
			bookingEntity.setUserId(userEntity);
			bookingEntity.setStatus(BookingStatus.PENDING);
			bookingEntity.setAddressId(addressEntity);
			bookingDao.save(bookingEntity);
			return "booking completed";
		}
		else
		return "booking failed";
	}
	
}
