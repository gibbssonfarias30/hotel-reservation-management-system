package com.backfcdev.hotelservice.client;

import com.backfcdev.hotelservice.model.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "room-service", path = "/api/v1/rooms")
public interface RoomsFeignClient {

    @GetMapping("/{hotelId}")
    List<Room> searchByHotelId(@PathVariable Long hotelId);
}
