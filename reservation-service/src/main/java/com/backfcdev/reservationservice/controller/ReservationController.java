package com.backfcdev.reservationservice.controller;

import java.util.List;

import com.backfcdev.reservationservice.config.AppConfig;
import com.backfcdev.reservationservice.model.PropertiesReservations;
import com.backfcdev.reservationservice.model.Reservation;
import com.backfcdev.reservationservice.service.IReservationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {

	private final IReservationService reservationService;
	private final AppConfig appConfig;


	@GetMapping
	ResponseEntity<List<Reservation>> search(){
		log.info("method search");
		return ResponseEntity.ok(reservationService.search());
	}


	@GetMapping("/read/properties")
	ResponseEntity<String> getPropertiesReservations() throws JsonProcessingException {
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		PropertiesReservations propertiesReservations = PropertiesReservations.builder()
				.msg(appConfig.getMsg())
				.buildVersion(appConfig.getBuildVersion())
				.mailDetails(appConfig.getMailDetails())
				.build();
		String jsonString = objectWriter.writeValueAsString(propertiesReservations);
		return ResponseEntity.ok(jsonString);
	}

}
