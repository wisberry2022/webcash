package com.bit.object;

import com.bit.util.CommonModel;

public class ModelA implements CommonModel {
	private String name;
	
	public ModelA() {}
	
	public ModelA(String name) {
		this.name = name;
	}
	
	public void func01() {
		System.out.println("ModelA_func01...");
	}
	
	public void func02() {
		System.out.println("-----------------------------------ModelA-----------------------------------");
		System.out.println("ModelA_func02 " + name);
	}
}
