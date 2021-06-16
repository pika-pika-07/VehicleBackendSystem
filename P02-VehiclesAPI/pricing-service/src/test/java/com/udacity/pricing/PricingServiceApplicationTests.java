package com.udacity.pricing;

import com.udacity.pricing.domain.price.Price;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PricingServiceApplicationTests {

	@Test
	public void contextLoads() {
	}
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	public void getPriceAndCheckValid() {
		ResponseEntity<Price> response  = this.restTemplate.getForEntity("http://localhost:" + port + "/services/price?vehicleId=19", Price.class);

		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

}
