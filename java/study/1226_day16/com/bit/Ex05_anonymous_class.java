package com.bit;

interface Inter{
	void func();
}

abstract class Lec05{
	void func02() {
		System.out.println("추상클래스의 기능");
	}
	
	public abstract void func();
}

class Lec55 {
	public void func() {
		System.out.println("본래 기능");
	};
}

class Outter05{
	// 익명 객체(anonymous class) - 한 번 호출하고 더 이상 사용하지 않을 객체를 생성하기 위해 사용한다.
	static void func01() {
		// Inter의 생성자가 아닌, Inter를 상속받는 클래스 이름이 생략된 것이다.
		Inter obj = new Inter(){
			public void func() {
				System.out.println("익명클래스만들기");
			}
		}; 	
		obj.func();
	}
}

public class Ex05_anonymous_class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Outter05.func01().func();
	}

}


//(new (){
//void func() {
//	System.out.println("익명클래스만들기");
//}
//}).func();

// 익명 함수
//new Loc().func();