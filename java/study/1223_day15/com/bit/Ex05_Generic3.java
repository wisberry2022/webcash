package com.bit;

class Lec05<V,T> {
	V su1;
	T su2;
	
	V getSu1() {return su1;}
	T getSu2() {return su2;}
	void setSu1(V su1) {this.su1 = su1;}
	void setSu2(T su2) {this.su2 = su2;}
}

public class Ex05_Generic3 {

	public static void main(String[] args) {
		Lec05<String, Integer> you = new Lec05<String, Integer>();
		you.setSu1("key1");
		you.setSu2(2);
		
		System.out.println(you.getSu1());
		System.out.println(you.getSu2());
	
		String su1 = you.getSu1();
		int su2 = you.getSu2();

	}

}
