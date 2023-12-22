package com.backfcdev.roomservice.service;

import java.util.List;

import com.backfcdev.roomservice.repository.IRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.backfcdev.roomservice.model.Room;

@RequiredArgsConstructor
@Service
public class RoomServiceImpl implements IRoomService {

	private final IRoomRepository roomRepository;


	@Override
	public List<Room> search() {
		return (List<Room>) roomRepository.findAll();
	}

	@Override
	public List<Room> searchRoomByHotelId(Long hotelId) {
		return roomRepository.findByHotelId(hotelId);
	}


}
