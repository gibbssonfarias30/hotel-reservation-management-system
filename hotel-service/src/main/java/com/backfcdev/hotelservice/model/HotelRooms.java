package com.backfcdev.hotelservice.model;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class HotelRooms {

    private Long hotelId;
    private String hotelName;
    private String hotelAddress;
    private List<Room> rooms;
}


