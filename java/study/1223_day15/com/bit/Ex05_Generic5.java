package com.bit;

import java.util.*;

public class Ex05_Generic5 {

	public static Box<? super Integer> func(int su) {
		if(su>0) {
			return new Box<Number>();	
		}else {
			return new Box<Integer>();
		}
	}
	
	public static void main(String[] args) {
		Box<String> box = new Box<String>();
		// Generic을 사용하지 않은 것과 마찬가지다.
		Box<String> box1 = new Box();
		Box box2 = new Box<String>();
		
		// Generic을 사용한 것(타입추론 적용)
		Box<String> box3 = new Box<>();
		// 타입의 결정을 나중으로 미루는 형식 - box4를 사용할 시점에는 반드시 Generic을 지정해주어야한다.
		Box<?> box4 = new Box<String>();
		
//		((Box<String>)box4).setSu("");
		
		

	}

}
