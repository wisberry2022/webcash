package com.bit.model;

import java.util.Arrays;

public class DeptDaoTest2 {
	static DeptDto target = new DeptDto();
	static DeptDao dao = new DeptDao();

	public static void testSelectAll() {
		System.out.println(dao.selectAll());
	}
	
	public static void testSelectOne() {
		System.out.println(dao.selectOne(20));
	}
	
	public static void testInsertOne() {
		target.setDeptno(50);
		target.setDname("DEVELOPE");
		target.setLoc("BUSAN");
		try {
			dao.insertOne(target.getDeptno(), target.getDname(), target.getLoc());	
		}catch(Exception e) {
			System.out.println("error");
		}	
	}
	
	public static void testUpdateOne() {
		target.setDeptno(60);
		target.setDname("Marketing");
	}
	
	public static void main(String[] args) {
		testInsertOne();
	}

}
