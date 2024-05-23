package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	@Value("${spring.datasource.username}")
	String username;
	@Test
	void contextLoads() {
	}
	@Test
	void dbUserNameIsSa(){
		assertEquals("sa", username);
	}
}
