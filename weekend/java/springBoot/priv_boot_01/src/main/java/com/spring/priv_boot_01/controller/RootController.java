package com.spring.priv_boot_01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

	@GetMapping("/")
	public String index(Model model) {
		String[] datas = new String[] {"hihi", "hihi2", "hihi3", "hihi4"};
		model.addAttribute("datas", datas);
		return "index";
	}
}
