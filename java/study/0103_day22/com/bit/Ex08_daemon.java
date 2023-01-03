package com.bit;

class Lec08 extends Thread {
	@Override
	public void run() {
		while(true) {
			System.out.println("running...");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

// daemon thread -> sub thread들이 종속된다.
public class Ex08_daemon {

	public static void main(String[] args) {
		System.out.println("main start...");
		Lec08 lec = new Lec08();
		lec.setDaemon(true);
		lec.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main end...");
	}

}
