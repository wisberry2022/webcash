package com.bit2;

interface Branch {
	public void func01();
	public void func02();
}

class Tree implements Branch {
	public void func01() {
		System.out.println("hello!!");
	}
	
	public void func02() {
		System.out.println("hello!!2");
	}
	
	public void func03() {
		System.out.println("hello!!3");
	}
}

public class Priv01 {

	public static void main(String[] args) {

//		Tree a = new Tree();
//		Branch b = a;
//		b.func01();
//		b.func02();
//		
		Branch c = new Tree();
		c.func01();
		c.func02();
//		c.func03();
		
		Tree a = new Tree();
		Branch b = a;
		
		b.func01();
		
	}

}
