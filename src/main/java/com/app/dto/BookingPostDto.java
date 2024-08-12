package com.app.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookingPostDto {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String date;
    @DateTimeFormat(pattern = "HH:mm")
	private String time;
}
