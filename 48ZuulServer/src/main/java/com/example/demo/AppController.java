package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@RequestMapping("/")
	public String home() {

		return "home";
	}


	@RequestMapping("/ajendra")
	public String products() {

		return "success";
	}

	@GetMapping("/getDS")
	public String getDoctorService() {

		return "Doctor microservice called...";
	}

	@GetMapping("/welcome/{name}")
	public String wish(@PathVariable String name) {

		return "Hi "+name+" Welcome to Doctor Service";
	}

}
