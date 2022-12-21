package com.bit2;

public class Ex10 {

	public static void main(String[] args) {
		StringBuffer st1 = new StringBuffer();
		StringBuffer st2 = new StringBuffer("java");
		StringBuffer st3 = new StringBuffer("Web");
		StringBuffer st4 = new StringBuffer(5);
		// 새로운 객체를 찍지 않아도 된다. 메소드 실행 시 자기 자신이 변경됨
		
		for(int i = 0; i<55; i++) {
			st4.append('a');
		}
		System.out.println(":" + st4.capacity());
		
		// 사용하지 않은 buffer를 제거한다.
		st2.trimToSize();
		
		System.out.println(st2.capacity());
		System.out.println(st3.capacity());
		
	}

}
