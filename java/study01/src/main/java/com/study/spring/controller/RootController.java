package com.study.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {
	
	@RequestMapping(value="/")
	public String indexControl() {
		return "index";
	}
	
}
