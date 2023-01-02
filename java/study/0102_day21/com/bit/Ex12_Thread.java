package com.bit;

public class Ex12_Thread {

	public static void main(String[] args) {
		// setPriority 1 ~ 10
		// default priority는 5이다.
		// max 10
		// min 1
		// 상대적 빈도수(priority의 숫자가 높을 수록 우선순위가 높아질 수도 있고, 숫자가 낮을수록 우선순위가 낮아질 수 있다)
		int mainPriority = Thread.currentThread().getPriority();
		System.out.println("main method priority" + mainPriority);
		
		// 아래는 Thread가 아니고, Thread가 수행할 동작을 정의하는 것이다.
		Runnable thr = new Runnable() {
			@Override
			public void run() {
				Thread thr = Thread.currentThread();
				int su = thr.getPriority();	// 스레드 우선순위
				System.out.println(thr.getName() + " New Thread start... " + su);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(thr.getName() + " New Thread end...");
			}
		};
		// Runnable 객체를 Thread 생성자에 인자로 넣을 수 있다.

		Thread thr1 = new Thread(thr);
		Thread thr2 = new Thread(thr);
		// 스레드 실행의 우선순위를 지정할 수 있다 -> 확률에 의존하기 때문에 사용자가 설정한대로 반드시 스레드가 동작하지 않는다.
		thr1.setPriority(Thread.MAX_PRIORITY);
		thr2.setPriority(Thread.MIN_PRIORITY);
		thr1.start();
		thr2.start();
	}

}
