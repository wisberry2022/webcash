package com.bit;

class Lec06 extends Thread {
	@Override
	public void run() {
		for(int i = 0; i<10; i++) {
			synchronized(this) {
				System.out.println(i + 1 +"번 수행...");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 동기화 처리 되어있지 않다면 오류가 발생한다
				if(i>1) notifyAll();
				
			}	
		}
	}
}

public class Ex06_wait_notify {
	public static void main(String[] args) {
		System.out.println("main start..");
		Lec06 lec = new Lec06();
		lec.start();
		synchronized(lec) {
			try {
				// main 스레드는 lec 스레드가 종료될 때까지 기다린다.
				lec.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
				
			}	
		}
		System.out.println("main end...");

	}

}
