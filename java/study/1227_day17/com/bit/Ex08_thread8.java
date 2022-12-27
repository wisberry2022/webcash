package com.bit;

public class Ex08_thread8 extends Thread {
	static int num = 0;
	
	public Ex08_thread8() {
		super("뉴스레드 " + ++num);
	}
	
	@Override
	public void run() {
		Thread thr = Thread.currentThread();
//		thr.setName("새로운 쓰레드");
		System.out.println(this.getName());
		System.out.println(thr.getName());
		System.out.println(thr == this);
		System.out.println(this.getId());
		System.out.println(thr.getId());
	}

	public static void main(String[] args) {
		Ex08_thread8 me = new Ex08_thread8();
		me.start();
	}

}
