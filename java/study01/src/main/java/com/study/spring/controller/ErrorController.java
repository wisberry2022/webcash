package com.study.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

	@RequestMapping(value="/err/{msg}")
	public String loginFail(@PathVariable String msg) {
		return "/err/"+msg;
	}
}
