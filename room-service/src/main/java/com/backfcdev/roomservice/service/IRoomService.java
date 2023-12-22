package com.backfcdev.roomservice.service;

import java.util.List;

import com.backfcdev.roomservice.model.Room;

public interface IRoomService {
	
	List<Room> search();

	List<Room> searchRoomByHotelId(Long hotelId);

}
