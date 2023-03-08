package com.bit.action;

import com.bit.concre.Car;
import com.bit.concre.Train;
import com.bit.str.Portable;
import com.bit.str.RailRoadStr;

public class Action {

	public static void main(String[] args) {
		Portable car = new Car();
		Portable train = new Train();
		
		car.move();
		train.move();
		
		car.setStrategy(new RailRoadStr());
		
		car.move();
	}
}
