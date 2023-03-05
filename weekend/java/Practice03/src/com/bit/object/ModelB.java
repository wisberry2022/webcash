package com.bit.object;

import com.bit.util.CommonModel;

public class ModelB implements CommonModel {
	private String name;
	
	public ModelB() {}
	
	public ModelB(String name) {
		this.name = name;
	}
	
	public void func01() {
		System.out.println("ModelB_func01...");
	}
	
	public void func02() {
		System.out.println("-----------------------------------ModelB-----------------------------------");
		System.out.println("ModelB_func02 " + name);
	}
}
