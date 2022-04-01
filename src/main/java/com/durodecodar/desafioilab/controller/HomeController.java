package com.durodecodar.desafioilab.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.durodecodar.desafioilab.model.Home;

@RestController
@CrossOrigin("*")
public class HomeController {
	@GetMapping("/")
	public Home index() {
		return new Home();
	}
}