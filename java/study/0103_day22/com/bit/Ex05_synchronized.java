package com.bit;

class Lec05 extends Thread {
	int su1, su2;
	static int sum;
	static Object key;
	
	public Lec05(int su1, int su2, Object key) {
		this.su1 = su1;
		this.su2 = su2;
		key = key;
	}
	
	// 동기화 - synchronized
	// 하나의 자원을 두고 두 개 이상의 스레드가 접근할 때 생기는 문제를 해결하기 위해 사용
//	public synchronized static void hap(int su1, int su2) {
//		for(int i = su1; i<=su2; i++) {
//			int tot = sum+i;
//			sum = tot;
//		}
//	}
	
//	public void hap(int su1, int su2) {
//		for(int i = su1; i<=su2; i++) {
//			// 두 객체가 서로 공통으로 갖는 Object를 key로 가져야한다
//			synchronized (this) {
//				int tot = sum+i;
//				sum = tot;	
//			}
//			
//		}
//	}
	
	// static을 주지 않을 경우 synchronized의 key는 자동으로 this가 들어가게 된다.
	// static일 경우 임의의 동일 객체가 key로 들어간다.
	public void hap(int a) {
		synchronized(key) {
			int tot = sum+a;
			sum = tot;	
		}
		
	}
	
	@Override
	public void run() {
		for(int i = su1; i<=su2; i++) {
			hap(i);	
		}

		System.out.println("합계는: " + sum);
	}
}

public class Ex05_synchronized {

	public static void main(String[] args) {
		Object key = new Object();
		Lec05 lec1 = new Lec05(1, 5000, new Object());
		Lec05 lec2 = new Lec05(5001, 10000, new Object());
		Thread thr1 = new Thread(lec1);
//		Thread thr2 = new Thread(lec2);
		thr1.start();
		thr2.start();

	}

}
