package com.bit.str;

public class CarRoadStr implements Strategy {

	@Override
	public void move(String transfer) {
		System.out.println(transfer + " 도로로 이동!");	
	}

}
