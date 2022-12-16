package com.bit;

// 부모클래스, super class
class Lec02{
	int su = 1;
	
	void func01() {
		System.out.println("부모기능");
	}	
}

// 자식클래스, sub class
public class Ex02 extends Lec02{
	
	void func02() {
		System.out.println("자식클래스의 기능");
	}
	
	public static void main(String[] args) {
		Ex02 me = new Ex02();
		System.out.println(me.su);
		me.func01();
	}
}
