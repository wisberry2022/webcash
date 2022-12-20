package com.bit;

public class Ex08 {

	public static void func(Object su) {	}
	
	// Wrapper 클래스 -> boxing / unboxing 지원
	public static void main(String[] args) {
		int su1 = 1111;
		Integer su2 = new Integer(3333);
		// Boxing
		Integer su3 = 3334;
		Integer su4 = new Integer("3333");	
		System.out.println(su4.intValue());
		int num = su4.intValue();
		System.out.println(su3.intValue() == su4.intValue());
		int num2 = Integer.parseInt("1234");
		System.out.println(num2);
		
		int su = 2;
		System.out.println(Integer.reverse(su));
		System.out.println(Integer.reverseBytes(su));
		
		String hex = Integer.toHexString(2);
		System.out.println(hex);
		int su5 = 16;
		System.out.println(Integer.toBinaryString(su5));
		System.out.println(Integer.toOctalString(su5));
		System.out.println(Integer.toHexString(su5));
		
		byte a = 10;
		Byte su10 = new Byte(a);
		
		// 같으면 0, 크면 1, 작으면 -1을 반환
		System.out.println(Integer.compare(su3,  su2));
		System.out.println(su2.compareTo(su3));
	}
}
