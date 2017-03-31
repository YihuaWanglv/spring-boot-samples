package com.iyihua.demos.cassandra;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iyihua.demos.cassandra.domain.Hotel;
import com.iyihua.demos.cassandra.repository.HotelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SampleCassandraApplicationTest {

	@Autowired
	private HotelRepository hotelRepository;

	@Test
	public void repositoryCrudOperations() {
		Hotel sample = sampleHotel();
		this.hotelRepository.save(sample);

		Hotel savedHotel = this.hotelRepository.findOne(sample.getId());
		System.err.println(savedHotel.getName());
		assertThat(savedHotel.getName(), equalTo("Sample Hotel"));

		this.hotelRepository.delete(savedHotel);
	}

	private Hotel sampleHotel() {
		Hotel hotel = new Hotel();
		hotel.setId(UUID.randomUUID());
		hotel.setName("Sample Hotel");
		hotel.setAddress("Sample Address");
		hotel.setZip("8764");
		return hotel;
	}

}
