package com.iyihua.demo.docker.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public Object home() {
		
		return "hello.";
	}
	
	@GetMapping("/new")
	public Object newApi() {
		
		return "hello. this is new......";
	}
}
