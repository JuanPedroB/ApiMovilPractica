package com.example.demo;

import java.time.LocalDateTime;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import com.example.demo.model.MovilService;
import com.example.demo.model.Response;

class ResponseTest {
	
	

	@Test
	void test() {
		
		MovilService movilService = new MovilService();
		
		Response response= Response.builder()
				.TimeStamp(LocalDateTime.now())
				.Status(HttpStatus.OK)
				.Message("currito que sabe")
				.Data(Map.of("moviles", movilService.getMoviles()))
				.build();
		System.out.println(response.getData().get("moviles").toString());
	}

}
