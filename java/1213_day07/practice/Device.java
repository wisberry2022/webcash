package com.Phone.Device;

public class Device {
	private String model;
	private String agency;
	private int storage;

	public Device(String model, String agency, int storage){
		this.model = model;
		this.agency = agency;
		this.storage = storage;
		System.out.println(this.agency + "통신사에서 " + this.model + " " + this.storage + "GB를 샀습니다!");
	}
}