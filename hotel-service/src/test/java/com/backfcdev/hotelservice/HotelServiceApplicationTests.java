package com.backfcdev.hotelservice;

import com.backfcdev.hotelservice.client.RoomsFeignClient;
import com.backfcdev.hotelservice.model.Hotel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		properties = {
				"spring.cloud.discovery.enabled=false",
				"spring.cloud.config.discovery.enabled=false"

		}
)
class HotelServiceApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;

//	@MockBean
//	RoomsFeignClient roomClient;

	@Test
	void findAll() {
		Hotel[] hotels = restTemplate.getForObject("/api/v1/hotels/", Hotel[].class);
		Assertions.assertTrue(hotels.length > 0);
	}

}
