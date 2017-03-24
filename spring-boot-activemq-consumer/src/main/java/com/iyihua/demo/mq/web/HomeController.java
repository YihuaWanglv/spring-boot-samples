package com.iyihua.demo.mq.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public Object home() {
		
		return "hello.";
	}
}
