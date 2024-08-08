package com.app.service;

import java.util.List;

import com.app.dto.BookingDto;

public interface BookingService {

	List<BookingDto> getAllBookings(Long userId);
    String deleteBooking(Long id);
}
