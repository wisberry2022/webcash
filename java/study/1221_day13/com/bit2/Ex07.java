package com.bit2;

public class Ex07 {

	public static void main(String[] args) {
		boolean boo1 = true;
		Boolean boo2 = new Boolean(true);
		Boolean boo3 = new Boolean("false");
		Boolean boo4 = new Boolean("TRUE");
		
		System.out.println(boo1);
		System.out.println(boo2);
		System.out.println(boo3);
		System.out.println(boo4);
		
		System.out.println(boo3.compareTo(boo4));
	}

}
