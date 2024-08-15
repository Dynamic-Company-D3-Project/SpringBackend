package com.app.dto;


import org.springframework.format.annotation.DateTimeFormat;


import Helpers.AddressTypeEnum;
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
    
    private AddressTypeEnum addressType;
    
}
