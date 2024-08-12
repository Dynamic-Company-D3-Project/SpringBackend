package com.app.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.Entities.BookingEntity;
import com.app.Entities.OrdersEntity;
import com.app.Entities.SubCategoryEntity;
import com.app.Entities.UserEntity;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.BookingDao;
import com.app.dao.OrdersDao;
import com.app.dao.SubCategoryDao;
import com.app.dao.UserDao;
import com.app.dto.BookingDto;
import com.app.dto.BookingPostDto;
import com.app.dto.OrdersDto;
import com.app.dto.SubCategoryDto;

import Helpers.BookingStatus;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SubCategoryDao subDao;
	
//	@Autowired
//	private ProviderSupportDao pDao;
	
	@Autowired
	private ModelMapper mapper;
	@Override
	public List<BookingDto> getAllBookings(Long userId) {
		System.out.println("getAllBookings "+ userId);
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
		bookingDao.delete(bookingEntity);
		return "booking deleted successfully";
	}
	@Override
	public String addBooking(Long id, Long uid, LocalDate date, LocalTime t) {
		if(subDao.existsById(id))
		{
			SubCategoryEntity subCategoryEntity = subDao.findById(id).orElseThrow(()->new ResourceNotFoundException("sub category not found"));
			UserEntity userEntity = userDao.findById(uid).orElseThrow(()->new ResourceNotFoundException("user not found"));
			BookingEntity bookingEntity= new BookingEntity();
			bookingEntity.setDate(date);
			bookingEntity.setTime(t);
			bookingEntity.setSubcategory_id(subCategoryEntity);
			bookingEntity.setUserId(userEntity);
			bookingEntity.setStatus(BookingStatus.PENDING);
			bookingDao.save(bookingEntity);
			return "booking completed";
		}
		else
		return "booking failed";
	}
	
}
