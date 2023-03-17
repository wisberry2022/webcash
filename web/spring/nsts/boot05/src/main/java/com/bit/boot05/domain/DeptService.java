package com.bit.boot05.domain;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bit.book05.domain.entity.DeptRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeptService {

	
	private final DeptRepo deptRepo;
	
	public List<?> selectAll() {
		return deptRepo.findAll();
	}  
}
