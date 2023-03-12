package com.gof.transfer;

import java.util.ArrayList;
import java.util.List;

import com.gof.util.Mobility;

public class Car implements Cloneable, Mobility {
	private List<String> riderList;
	private String name;
	private String rider;
	
	public Car() {
		System.out.println("자동차 생성!");
	}
	
	public Car(String name, String rider) {
		riderList = new ArrayList<>();
		this.name = name;
		this.rider = rider;
	}
	
	public void drive() throws Exception {
		if(rider != null) {
			System.out.println(rider + "가 운전하는 " + name + "가 주행을 시작했습니다");	
		}else {
			throw new Exception("No rider name!");
		}		
	}
	
	@Override
	public void ride(String...names) {
		for(String name:names) {
			System.out.println(name + "이 탑승하셨습니다!");
			riderList.add(name);
		}
	}

	public void check() {
		System.out.println("--------------------탑승자 목록--------------------");
		for(String rider:riderList) {
			System.out.println(rider);
		}
		System.out.println("--------------------탑승자 목록--------------------");
	}
	
	@Override
	public void down(String name) {
		if(riderList.contains(name)) {
			riderList.remove(name);
			System.out.println(name + "이 하차하였습니다!");
		}
		
	}
	
	@Override
	public Object clone() {
		String name,rider;
		List<String> riderList = new ArrayList<>();
		for(String ridername:this.riderList) {
			riderList.add(ridername);
		}
		name = this.name;
		rider=  this.rider;
		return new Car(name, rider);
	}
}
