package com.woowa.supp.web;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void loadIndex() {
		String body = restTemplate.getForObject("/", String.class);

		assertThat(body).contains("supp");
	}
}
