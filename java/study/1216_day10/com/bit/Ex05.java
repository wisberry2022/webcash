package com.bit;

class Lec05 {
	int su1 = 1111;
	void func01() {
		System.out.println("부모 기능");
	}
}

public class Ex05 extends Lec05 {
	int su1 = 2222;
	void func01() {
		System.out.println("---------------------------");
//		super.func01();
		System.out.println("자식 기능");
		System.out.println("---------------------------");
	}
	
	void func02() {
		System.out.println("다른 기능");
	}
	
	void func03() {
		System.out.println("다른 기능3");
	}
	
	public static void main(String[] args) {
//		Lec05 me1 = new Lec05();
//		me1.func01();
		Ex05 me2 = new Ex05();
		me2.func01();
		((Lec05)(me2)).func01();
//		me2.func02();
		// 상속 관계에 있을 경우, 선언은 부모 클래스로 선언하되, 자식 클래스로 초기화 할 수 있다.
//		Lec05 me3 = new Ex05();
//		me3.func01();
		// me3는 자식에게만 존재하는 메서드는 사용할 수 없다
		// 하지만 자식 클래스를 강제로 형변환하면, 자식 메서드를 사용할 수 있다. 
//		((Ex05)(me3)).func02();
	}

}
