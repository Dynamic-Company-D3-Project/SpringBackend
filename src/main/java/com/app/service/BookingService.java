package com.app.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.app.dto.BookingDto;
import com.app.dto.BookingPostDto;

public interface BookingService {

	List<BookingDto> getAllBookings(Long userId);
    String deleteBooking(Long id);
    String addBooking(Long id,Long uid,LocalDate date,LocalTime t);
}
