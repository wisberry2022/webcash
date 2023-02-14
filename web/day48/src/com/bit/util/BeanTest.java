package com.bit.util;

import com.bit.model.DeptDto;

public class BeanTest {

	public static void main(String[] args) {
		DeptDto bean = new DeptDto();
		bean.setDeptno(10);
		bean.setDname("hi");
		bean.setLoc("er");
		System.out.println(bean.toString());

	}

}
