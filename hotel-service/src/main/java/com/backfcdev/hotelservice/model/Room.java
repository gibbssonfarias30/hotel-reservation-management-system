package com.backfcdev.hotelservice.model;


import lombok.Data;

@Data
public class Room {

    private Long roomId;
    private Long hotelId;
    private String roomName;
    private String roomAvailable;
}
