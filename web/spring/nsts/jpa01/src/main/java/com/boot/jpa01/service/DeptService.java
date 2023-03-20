package com.boot.jpa01.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.jpa01.domain.DeptRepo;
import com.boot.jpa01.domain.DeptVo;
import com.boot.jpa01.domain.entity.Dept;

@Service
public class DeptService {

	@Autowired
	private DeptRepo deptRepo;
	
	public List<DeptVo> selectAll() {
		List<DeptVo> list = new ArrayList<>();
		for(Dept bean:deptRepo.findAll()) {
			list.add(DeptVo.builder()
					.deptno(bean.getDeptno())
					.dname(bean.getDname())
					.loc(bean.getLoc())
					.build());
		}
		return list;
	}
}
