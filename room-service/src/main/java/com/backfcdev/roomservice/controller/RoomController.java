package com.backfcdev.roomservice.controller;

import java.util.List;

import com.backfcdev.roomservice.config.AppConfig;
import com.backfcdev.roomservice.model.PropertiesRooms;
import com.backfcdev.roomservice.model.Room;
import com.backfcdev.roomservice.service.IRoomService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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
@RequestMapping("/api/v1/rooms")
public class RoomController {


	private final IRoomService roomService;
	private final AppConfig appConfig;

	@GetMapping
	ResponseEntity<List<Room>> search(){
		log.info("method search");
		return ResponseEntity.ok(roomService.search());
	}

	@GetMapping("/{hotelId}")
	ResponseEntity<List<Room>> searchByHotelId(@PathVariable Long hotelId){
		log.info("method searchByHotelId");
		return ResponseEntity.ok(roomService.searchRoomByHotelId(hotelId));
	}

	@GetMapping("/read/properties")
	ResponseEntity<String> getPropertiesRooms() throws JsonProcessingException {
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
		PropertiesRooms propertiesRooms = PropertiesRooms.builder()
				.msg(appConfig.getMsg())
				.buildVersion(appConfig.getBuildVersion())
				.mailDetails(appConfig.getMailDetails())
				.build();
		String jsonString = objectWriter.writeValueAsString(propertiesRooms);
		return ResponseEntity.ok(jsonString);
	}
}
