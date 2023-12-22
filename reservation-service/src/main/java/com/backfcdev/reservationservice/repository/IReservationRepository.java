package com.backfcdev.reservationservice.repository;

import com.backfcdev.reservationservice.model.Reservation;
import org.springframework.data.repository.CrudRepository;


public interface IReservationRepository extends CrudRepository<Reservation, Long>{

}
