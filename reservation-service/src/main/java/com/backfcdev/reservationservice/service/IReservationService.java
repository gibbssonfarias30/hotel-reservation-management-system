package com.backfcdev.reservationservice.service;

import java.util.List;

import com.backfcdev.reservationservice.model.Reservation;


public interface IReservationService {
	
	List<Reservation> search();

}
