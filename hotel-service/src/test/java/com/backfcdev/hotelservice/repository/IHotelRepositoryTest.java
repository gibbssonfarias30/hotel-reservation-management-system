package com.backfcdev.hotelservice.repository;

import com.backfcdev.hotelservice.model.Hotel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class IHotelRepositoryTest {


    @Autowired
    private IHotelRepository hotelRepository;

    @Autowired
    private TestEntityManager testEntityManager;


    @BeforeEach
    void setUp() {
        Hotel hotel = Hotel.builder()
                .hotelId(1L)
                .hotelName("Hotel Hacienda")
                .hotelAddress("Occidente MSF")
                .build();
        testEntityManager.merge(hotel);
    }


    @Test
    void findAll(){
        List<Hotel> hotels = (List<Hotel>) hotelRepository.findAll();
        assertEquals(hotels.size(), 1);
    }
}