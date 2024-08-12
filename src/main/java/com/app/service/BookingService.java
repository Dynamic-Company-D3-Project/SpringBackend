package com.app.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.app.dto.BookingDto;
import com.app.dto.BookingPostDto;

public interface BookingService {

	List<BookingDto> getAllBookings(String token);
    String deleteBooking(Long id);
    String addBooking(Long id,String token,LocalDate date,LocalTime t);
}
