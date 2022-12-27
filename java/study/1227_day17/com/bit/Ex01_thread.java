package com.bit;

public class Ex01_thread {

	public static void func01() {
		System.out.println("func01 start");
		System.out.println(Thread.currentThread().getName());
		System.out.println("func01 end");
	}
	
	public void func02() {
		System.out.println("func01 start");
		System.out.println(Thread.currentThread().getName());
		System.out.println("func01 end");
	}
	
	public static void main(String[] args) {
		System.out.println("main start");
		System.out.println(Thread.currentThread().getName());
		System.out.println("main end");
		func01();
		Ex01_thread me = new Ex01_thread();
		me.func02();

	}

}
