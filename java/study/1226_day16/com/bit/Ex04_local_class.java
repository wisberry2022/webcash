package com.bit;

class Outter04 {
	static int su1 = 1111;
	int su2 = 2222;
	
	static void func01() {
//		메소드가 실행되어야지만 존재하게 되는 클래스다.(static field / method 불가)
		class Loc01 {
			int su3 = 3333;
			void func02() {
				System.out.println(su1);
				func01();
				Outter04 outt = new Outter04();
				System.out.println(outt.su2);
				outt.func02();
			}
		}
		
		Loc01 loc = new Loc01();
		System.out.println(loc.su3);
		loc.func02();
	}
	
	void func02() {
		int su5 = 5555;	// jdk1.8~ final 키워드 생략 가능
		class Loc02 {
			int su3 = 3333;
			void func02() {
				System.out.println(su5);
				func01();
				System.out.println(su2);
				func02();
			}
		}
		Loc02 loc = new Loc02();
		System.out.println(loc.su3);
		loc.func02();
	}
}

public class Ex04_local_class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outter04 outt = new Outter04();
		outt.func02();
	}

}
