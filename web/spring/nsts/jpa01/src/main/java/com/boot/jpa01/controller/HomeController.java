package com.boot.jpa01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.jpa01.domain.DeptVo;
import com.boot.jpa01.service.DeptService;

@RestController
public class HomeController {

	@Autowired
	private DeptService deptService;
	
	@GetMapping("/api/")
	public List<DeptVo> selectAll() {
		List<DeptVo> list = deptService.selectAll();
		return list;
	}
	
}
