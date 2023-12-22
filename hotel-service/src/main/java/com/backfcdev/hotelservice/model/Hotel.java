package com.backfcdev.hotelservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter @ToString
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="hotel_id")
	private Long hotelId;
	
	@Column(name="hotel_name")
	private String hotelName;
	
	@Column(name="hotel_address")
	private String hotelAddress;

}
