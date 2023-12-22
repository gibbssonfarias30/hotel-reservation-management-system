package com.backfcdev.hotelservice.controller;

import java.util.List;
import java.util.Properties;

import com.backfcdev.hotelservice.config.AppConfig;
import com.backfcdev.hotelservice.model.Hotel;
import com.backfcdev.hotelservice.model.HotelRooms;
import com.backfcdev.hotelservice.model.PropertiesHotels;
import com.backfcdev.hotelservice.model.Room;
import com.backfcdev.hotelservice.service.IHotelService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/hotels")
public class HotelController {

	private final IHotelService hotelService;
	private final AppConfig appConfig;
	
	@GetMapping
	ResponseEntity<List<Hotel>> search(){
		log.info("method search");
		return ResponseEntity.ok(hotelService.search());
	}


	//@CircuitBreaker(name = "searchByHotelIdSupportCB", fallbackMethod = "searchByHotelIdAlternative")
	@Retry(name = "searchByHotelIdSupportRetry", fallbackMethod = "searchByHotelIdAlternative")
	@GetMapping("/{hotelId}")
	ResponseEntity<HotelRooms> searchByHotelId(@PathVariable Long hotelId){
		log.info("method searchByHotelId");
		return ResponseEntity.ok(hotelService.searchByHotelId(hotelId));
	}

	ResponseEntity<HotelRooms> searchByHotelIdAlternative(@PathVariable Long hotelId, Throwable throwable){
		return ResponseEntity.ok(hotelService.searchByHotelIdWithoutRooms(hotelId));
	}

	@GetMapping("/read/properties")
	ResponseEntity<String> getPropertiesHotels() throws JsonProcessingException {
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		PropertiesHotels propertiesHotels = PropertiesHotels.builder()
				.msg(appConfig.getMsg())
				.buildVersion(appConfig.getBuildVersion())
				.mailDetails(appConfig.getMailDetails())
				.build();
		String jsonString = objectWriter.writeValueAsString(propertiesHotels);
		return ResponseEntity.ok(jsonString);
	}

}
