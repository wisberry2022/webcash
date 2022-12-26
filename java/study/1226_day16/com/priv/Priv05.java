package com.priv;

interface addOn {
	int addFunc(int num1, int num2);
	void addFunc02();
}

class Factory {
	addOn func01() {
		return new addOn() {
			public int addFunc(int num1, int num2) {
				System.out.println("익명 객체 생성!");
				return num1 + num2;
			}
			
			public void addFunc02() {
				System.out.println("second function!");
			}
		};
	}
	
	void func02() {
		System.out.println("Factory ON!");
	}
	
}

public class Priv05 {

	public static void main(String[] args) {
		Factory fc = new Factory();
		fc.func02();
		
		int num = fc.func01().addFunc(2,3);
		System.out.println(num);
		fc.func01().addFunc02();
	}

}
