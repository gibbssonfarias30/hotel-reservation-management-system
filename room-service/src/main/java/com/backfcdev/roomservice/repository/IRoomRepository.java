package com.backfcdev.roomservice.repository;

import com.backfcdev.roomservice.model.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface IRoomRepository extends CrudRepository<Room, Long> {

    List<Room> findByHotelId(Long hotelId);
}
