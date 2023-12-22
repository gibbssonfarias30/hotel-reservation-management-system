package com.backfcdev.hotelservice.service;

import java.util.List;

import com.backfcdev.hotelservice.model.Hotel;
import com.backfcdev.hotelservice.model.HotelRooms;

public interface IHotelService {
	
	List<Hotel> search();
	HotelRooms searchByHotelId(Long hotelId);
	HotelRooms searchByHotelIdWithoutRooms(Long hotelId);

}
