package com.bit;

public class Ex03_threadControl2 extends Thread{

	@Override
	public void run() {
		try {
			while(true) {
				System.out.println(getName() + " working...");
				Thread.sleep(10000);
			}
		} catch (InterruptedException e) {
		}
		
	}
	
	public static void main(String[] args) {
		Ex03_threadControl2 me = new Ex03_threadControl2();
		Ex03_threadControl2 you = new Ex03_threadControl2();
		
		me.start();
		you.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		
		// sleep 상황에 있는 you 스레드를 3초뒤에 깨운 것
		you.interrupt();

	}

}
