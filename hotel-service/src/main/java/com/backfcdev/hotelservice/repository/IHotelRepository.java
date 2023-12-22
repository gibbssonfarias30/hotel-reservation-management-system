package com.backfcdev.hotelservice.repository;

import com.backfcdev.hotelservice.model.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface IHotelRepository extends CrudRepository<Hotel, Long> {
}
