package com.bit;

// 와일드카드의 경우 우선순위가 떨어진다.
// 컴파일러가 메인 메소드에 작성된 메소드나 클래스를 검사할 때, 동일 패키지 내에 존재하지 않을 경우에 와일드카드를 임포트한 패키지를 탐색하게 된다.
import com.bit2.*;

public class Ex02 {

	public static void main(String[] args) {
		
		com.bit.Ex01 me0 = new com.bit.Ex01();
		Ex01 me1 = new Ex01();
		Ex11 me2 = new Ex11();
		System.out.println(me1.su);
	}

}
