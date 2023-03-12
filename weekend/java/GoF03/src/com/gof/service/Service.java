package com.gof.service;

import com.gof.transfer.Car;

public class Service {

	public static void main(String[] args) {
		
		Car c = new Car("소나타","김진수");
		try {
			c.drive();
			c.ride("김민우","박영훈","오정은");
			c.check();
			Car d = (Car)c.clone();
			d.check();
			d.drive();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
