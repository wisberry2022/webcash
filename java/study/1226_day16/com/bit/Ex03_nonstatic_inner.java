package com.bit;

class Outter03 {
	static int su1 = 1111;
	int su2 = 2222;
	
	// 내부에 static 사용 불가
	class Inner03{
		// Inner03은 Outter03의 구성요소로서 존재한다. Inner03은 static이 아니라, 반드시 직접 선언해주어야 활용이 가능하다. 따라서 non-static member class에서는 static 요소를 사용할 수 없다. 
		final static int su3 = 3333;
		int su4 = 4444;
		Inner03() {}
		void func04() {
			// 안쪽에서 외부 클래스의 것을 사용하는 것은 자유롭다. 
			System.out.println(su1);
			System.out.println(su2);
			func01();
			func02();
		}
	}
	
	Outter03() {}
	
	static void func01() {
		System.out.println(Inner03.su3);
		Outter03 outt = new Outter03();
		Inner03 inn = outt.new Inner03();
		System.out.println(inn.su4);
		inn.func04();
	}
	void func02() {
		System.out.println(Inner03.su3);
		Inner03 inn = new Inner03();
		System.out.println(inn.su4);
		inn.func04();
	}
}

public class Ex03_nonstatic_inner {

	public static void main(String[] args) {
		System.out.println(Outter03.Inner03.su3);
		Outter03 outt = new Outter03();
		Outter03.Inner03 inn = outt.new Inner03();
		System.out.println(inn.su4);
		inn.func04();
	}

}
