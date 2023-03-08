package com.bit.concre;

import com.bit.str.Portable;
import com.bit.str.RailRoadStr;
import com.bit.str.Strategy;

public class Train implements Portable {
	private Strategy str;
	
	public Train() {
		this.str = new RailRoadStr();
	}
	
	public void move() {
		str.move("기차-");
	}

	@Override
	public void setStrategy(Strategy target) {
		this.str = target;
	}
}
