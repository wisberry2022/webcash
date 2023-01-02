package com.bit;

public class Ex08_finally {

	public static void func() {
		System.out.println("func start...");
		
//		try {
//			int a = 4;
//			int b = 2;
//			int c = a/b;
//			System.out.println(c);
//		}catch(ArithmeticException e) {
//			return;
//		}finally {
//			// finally를 사용하기 위해서는 불필요한 try-catch 문을 작성하여야한다. 이를 방지하기 위해 try-finally 문법이 생겼다.
//			System.out.println("func end...");	
//		}
		
		try {
			int a = 4;
			int b = 2;
			int c = a/b;
			System.out.println(c);
			return;
		}finally {
			System.out.println("func end...");
		}
		
	}
	
	public static void main(String[] args) {
	func();

	}

}
