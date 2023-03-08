package com.bit.concre;

import com.bit.str.CarRoadStr;
import com.bit.str.Portable;
import com.bit.str.Strategy;

public class Car implements Portable {
	private Strategy str;
	
	public Car() {
		this.str = new CarRoadStr();
	}
	
	@Override
	public void move() {
		str.move("자동차-");
	}

	@Override
	public void setStrategy(Strategy target) {
		this.str = target;
		
	}

}
