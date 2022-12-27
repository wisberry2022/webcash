package com.bit;

public class Ex09_thread9 extends Thread {

	@Override
	public void run() {
		System.out.println("새로운 쓰레드 시작");
		try {
			sleep(1000);	
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("새로운 쓰레드 끝");
	}
	
	public static void main(String[] args) {
		Ex09_thread9 me = new Ex09_thread9();
		me.start();
		System.out.println("main start");
		
		try {
			Thread.sleep(1000);	
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("main end");

	}

}
