package com.bit;

public class Ex06 {

	public static void main(String[] args) {
		int su1 = 2;
		int su2 = 5;
		int su3 = -34;
		System.out.println(Math.abs(su1));
		System.out.println(Math.abs(su2));
		System.out.println(Math.abs(su3));
		
		double su4 = 3.14;
		double su5 = 3.54;
		double su6 = 3.94;
		System.out.println(Math.ceil(su4));
		System.out.println(Math.ceil(su5));
		System.out.println(Math.ceil(su6));
		System.out.println(Math.floor(su4));
		System.out.println(Math.floor(su5));
		System.out.println(Math.floor(su6));
		System.out.println(Math.round(su4));
		// 반환 타입은 long type
		System.out.println(Math.round(su5));
		System.out.println(Math.round(su6));
		System.out.println(Math.min(su1, su4));
		System.out.println(Math.max(su1, su4));
		// Returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0.
		System.out.println((int)(Math.random()*10));
	}

}
