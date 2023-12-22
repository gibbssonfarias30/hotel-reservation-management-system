package com.backfcdev.reservationservice.model;

import java.sql.Date;

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
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="reservation_id")
	private Long reservationId;
	
	@Column(name="room_id")
	private Long roomId;
	
	@Column(name="start_dt")
	private Date startDt;
	
	@Column(name="finish_dt")
	private Date finishDt;

}
