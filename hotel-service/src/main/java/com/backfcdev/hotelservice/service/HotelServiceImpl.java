package com.backfcdev.hotelservice.service;

import java.util.List;
import java.util.Optional;

import com.backfcdev.hotelservice.client.RoomsFeignClient;
import com.backfcdev.hotelservice.model.HotelRooms;
import com.backfcdev.hotelservice.model.Room;
import com.backfcdev.hotelservice.repository.IHotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.backfcdev.hotelservice.model.Hotel;

@RequiredArgsConstructor
@Service
public class HotelServiceImpl implements IHotelService {

	private final IHotelRepository hotelRepository;

	private final RoomsFeignClient roomsFeignClient;

	@Override
	public List<Hotel> search() {
		return (List<Hotel>) hotelRepository.findAll();
	}

	@Override
	public HotelRooms searchByHotelId(Long hotelId) {
		Hotel hotel = hotelRepository.findById(hotelId).orElseThrow();
		List<Room> rooms = roomsFeignClient.searchByHotelId(hotelId);

		return HotelRooms.builder()
				.hotelId(hotel.getHotelId())
				.hotelName(hotel.getHotelName())
				.hotelAddress(hotel.getHotelAddress())
				.rooms(rooms)
				.build();
	}

	@Override
	public HotelRooms searchByHotelIdWithoutRooms(Long hotelId) {
		Hotel hotel = hotelRepository.findById(hotelId).orElseThrow();
		return HotelRooms.builder()
				.hotelId(hotel.getHotelId())
				.hotelName(hotel.getHotelName())
				.hotelAddress(hotel.getHotelAddress())
				.build();
	}
}
