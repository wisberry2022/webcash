package com.bit;

public class Ex02_threadControl extends Thread {

	@Override
	public void run() {
		System.out.println(getName() + " start...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(getName() + " end...");
	}
	
	public static void main(String[] args) {
		System.out.println("main start...");
		Ex02_threadControl me = new Ex02_threadControl();
		me.start();
		try {
			// me 스레드가 wait 상태로 들어가게 된다.
			// 이 때 특정 시간만큼 wait 상태로 들어가게 할 수 있다.
			// 특정 시간을 명시하지 않을 경우 다른 스레드가 재실행될떄까지 기다린다.
			me.join(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("main end...");
		
	}

}
