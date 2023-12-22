package com.backfcdev.roomservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="room_id")
	private Long roomId;
	
	@Column(name="hotel_id")
	private Long hotelId;
	
	@Column(name="room_name")
	private String roomName;
	
	@Column(name="room_available")
	private String roomAvailable;

}




