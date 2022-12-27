package com.bit;

public class Ex07_thread7 implements Runnable {

	@Override
	public void run() {
		// this가 Thread가 아닐 경우 / static 메서드일 경우 Thread.currentThread()를 통해 최근 생성된 스레드 정보를 받을 수 있다.
//		Thread thr = Thread.currentThread();
//		System.out.println(thr.getName());
		func();
	}
	
	public static void func() {
		Thread thr = Thread.currentThread();
		System.out.println(thr.getName());
	}
	
	public static void main(String[] args) {
		Ex07_thread7 me = new Ex07_thread7();
		func();
		Thread thr = new Thread(me);
		thr.start();
		

	}

}
