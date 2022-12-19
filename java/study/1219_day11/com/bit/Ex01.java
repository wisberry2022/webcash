package com.bit;

// 추상 클래스 - 추상메서드를 0개 이상 갖는 클래스
abstract class Lec06 {
	int su1 = 1111;
	
	public Lec06(int su1) {
		this.su1 = su1;
	}
	
	abstract void func01();
	
	public void func02() {}
}

public class Ex01 extends Lec06 {
	
	public Ex01() {
		super(1234);
	}
	
	public void func01() {
		System.out.println("부모의 기능을 오버라이드...");
	};
	
	public static void main(String[] args) {
		Ex01 me = new Ex01();
//		me.func01();
		Lec06 you = new Ex01();
//		you.func01();
	}

}
