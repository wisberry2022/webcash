package com.bit;

public class Ex04_yield extends Thread{
	boolean boo;
	
	public Ex04_yield(boolean boo) {
		this.boo = boo;
	}
	@Override
	public void run() {
		for(int i = 0; i<100; i++) {
			if(boo) {
				yield();
				System.out.println(getName() + "가 양보했습니다! 대단~" + i);
			}else {
				System.out.println(getName() + " working... " + i);	
			}
			
		}
	}
	
	public static void main(String[] args) {
		Ex04_yield ex1 = new Ex04_yield(true);
		Ex04_yield ex2 = new Ex04_yield(false);
		ex1.start();
		ex2.start();

	}

}
