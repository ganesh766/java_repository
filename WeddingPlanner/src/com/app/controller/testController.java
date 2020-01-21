package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class testController {

	public testController() {
		System.out.println("default constr");
	}
	
	@GetMapping
	public String test() {
		return "sunbeam";
	}
}
