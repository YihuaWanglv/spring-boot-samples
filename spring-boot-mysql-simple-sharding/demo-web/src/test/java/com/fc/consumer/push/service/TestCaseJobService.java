package com.fc.consumer.push.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCaseJobService {

	@SuppressWarnings("unused")
	@Autowired private StringRedisTemplate redisTemplate;
	
//	@Test
	public void saveJob() {
		
	}

}
