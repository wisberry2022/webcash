package com.bit.boot09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	public String index() {
		return "index";
	}
	
	@GetMapping("/ex01")
	public String ex01() {
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02() {
		return "ex02";
	}
	
	@GetMapping("/ex03")
	public String ex03() {
		return "ex03";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
