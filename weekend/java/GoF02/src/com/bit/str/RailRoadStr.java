package com.bit.str;

public class RailRoadStr implements Strategy {

	@Override
	public void move(String transfer) {
		System.out.println(transfer + " 선로로 이동");
	}

}
