package com.bit;

// Thread의 상속을 통해 Thread 실행
class Small extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("또 다시 새로운 스레드!");
	}
}

public class Ex02_thread2 extends Thread {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("새로운 스레드로 작업 시킵니다!");
	}
	
	public static void main(String[] args) {
		System.out.println("main start");
		String name = Thread.currentThread().getName();
		System.out.println(name);
		Ex02_thread2 thr = new Ex02_thread2();
		thr.start();
		
		for(int i = 0; i<10; i++) {
			System.out.println(name + " work!");
		}
		System.out.println(name + " end");
		Small you = new Small();
		you.start();
	}

}
