package com.bit.service;

import com.bit.util.CommonModel;

public class Service {
	private CommonModel model;
	
	public Service() {	}
	
	public Service(CommonModel model) {
		this.model = model;
	}
	
	public void doService() {
		if(model != null) {
			model.func01();
			model.func02();
			return;
		}
		System.out.println("No Model!");		
	}
}
