package com.bit;

public class Ex01 {
	public static void main(String[] args) {
		// continue; return; break;
		func04();
	}
	
	public static void func01() {
		for(int i = 0; i<10; i++) {
			System.out.println(i+"번째 before");
			if(i>5) return;	
			System.out.println(i+"번째 after");
		}
	}
	
	public static void func02() {
		for(int i = 0; i<5; i++) {
			for(int j = 0; j<5; j++) {
				if(i==2) continue;
				System.out.println("i="+i+", j="+j);
			}
		}
	}
	
	public static void func03() {
		System.out.println("func03 start");
		for(int i = 0; i<10; i++) {
			switch(i) {
				case 5 :break;
				case 3 :System.out.println("case="+i);
				case 1 :
			}
			System.out.println("실행 중..." + i);
		}
		System.out.println("func03 end");
	}
	
	public static void func04() {
		System.out.println("func04 START!...");
		int num = 0;
		while(true) {
			if(num == 4) {
				break;
			}
			System.out.println(num + "번째 실행...");
			num++;
		}
		System.out.println("func04 END!...");
	}
}
