package com.gof.obj;

public class Item {
	private String name;
	private int cost;
	
	public Item(String name, int cost) {
		this.name = name;
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return "(" + name + ", " + cost + ")";
	}
}
