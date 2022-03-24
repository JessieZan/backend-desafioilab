package com.durodecodar.desafioilab.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("messages")
public class MessageController {
	@Value("${teste.url}")
	private String testee;
	@GetMapping(value = "/welcome")
	public ResponseEntity getWelcomeMessage() {
		return new ResponseEntity(testee, HttpStatus.OK);
	}
	
}
