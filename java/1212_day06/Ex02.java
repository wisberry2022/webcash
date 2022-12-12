package com.my;
// 클래스의 이름은 첫글자 대문자 영문으로 시작

class Ex02 {
	public static void func01(int a) {
		if (a == 0) {
			return;
		}
		System.out.println("전달받은 a="+a);
	}

	public static int func01() {
		System.out.println("첫 번째");
		func02(1111);
		return 1234;
	}

	public static void func02(int a) {
		System.out.println("두 번째! "+a);
		return;
	}

	public static void main(String[] args){
		System.out.println("한글...Ex02...");
		int a = 1111;
		func01(2222);
		for(int i =0; i<5; i++){
			System.out.println(a);
		}
		System.out.println("종료"+a);
		return;
	}
}