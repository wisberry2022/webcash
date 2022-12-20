package com.bit;

class Parent {
	void func01() {
		System.out.println("부모 기능!");
	}
}

class Child extends Parent {
	void func02() {
		System.out.println("자식 기능!");
	}
	
	void func03() {
		System.out.println("자식 기능 두번째~");
	}
}


public class Priv01 {

	public void funcPriv() {
		System.out.println("Priv01 Func!");
	}
	public static void main(String[] args) {
		
		Child c = new Child();
		// 업캐스팅
		Parent d = (Parent)c;
		// 다운캐스팅
		Child e = (Child)d;
		e.func02();
		e.func03();
		e.func01();

	}

}
