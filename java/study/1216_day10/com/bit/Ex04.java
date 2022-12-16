package com.bit;

class Lec04{
	int su1 = 1111;
	void func01() {
		System.out.println("root 기능");
	}
}

class Lec44 extends Lec04 {
	
}

class Lec444 extends Lec04 {
	
}

public class Ex04 extends Lec04 {
	int su1 = 1112;
	int su;
	
	public Ex04(int su) {
		this.su = su;
	}
	
	@Override
	public void func01() {
		System.out.println("sub 기능!");
	}

	// java.lang.Object에 포함된 equals를, 객체에서도 값비교를 할 수 있도록 오버라이드한 것
	public boolean equals(Object obj) {
		return 0 == this.su-((Ex04)obj).su; 
	}
	
	public static void main(String[] args) {
		Ex04 me = new Ex04(5);
		Ex04 you = new Ex04(5);
		me.func01();
		System.out.println(me.equals(you));
		
		String msg1 = "하이";
		String msg2 = "하이";
		String msg3 = new String("하이");
		System.out.println(msg1 == msg2);
		System.out.println(msg1 == msg3);
	}

}
