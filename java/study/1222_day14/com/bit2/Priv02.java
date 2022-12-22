package com.bit2;

class Parent {
	public void pFunc01() {
		System.out.println("parent func!");
	}
	
	public void pFunc02() {
		System.out.println("parent func2!");
	}
}

class Child extends Parent {
	
	public void pFunc01() {
		System.out.println("child func! with parent");
	}
	
	public void pFunc02() {
		System.out.println("child func2! with parent");
	}
	
	public void cFunc01() {
		System.out.println("this is only child func!");
	}
}

public class Priv02 {

	public static void main(String[] args) {
		Parent a = new Child();
		
		((Child)(a)).cFunc01();
		
//		c.pFunc01();
		
//		a.pFunc01();
//		
//		((Child)(a)).cFunc01();
		
//		Parent p = new Parent();
//		Parent p2 = new Child();
//		((Child)(p2)).cFunc01();
//
//		Child p3 = (Child)p2;
//		p3.pFunc01();
		
	}

}
