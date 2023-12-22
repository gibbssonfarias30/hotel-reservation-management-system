package com.backfcdev.reservationservice.service;

import java.util.List;

import com.backfcdev.reservationservice.repository.IReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.backfcdev.reservationservice.model.Reservation;

@RequiredArgsConstructor
@Service
public class ReservationServiceImpl implements IReservationService {

	private final IReservationRepository reservationRepository;


	@Override
	public List<Reservation> search() {
		return (List<Reservation>) reservationRepository.findAll();
	}

}
