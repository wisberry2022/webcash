package com.bit.book05.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.boot05.domain.DeptService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/")
public class DeptController {

	private final DeptService deptService;
	
	@GetMapping
	public List getlist() {
		return deptService.selectAll();
	}
}
