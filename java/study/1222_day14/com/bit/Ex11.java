package com.bit;

import java.util.*;

public class Ex11 {

	// 비선형 자료구조 - 순서가 존재하지 않는 자료구조(집합) 
	// 1. 중복을 허용하지 않는다
	// 2. 순서가 없다고 하였으나, 사실은 순서가 존재한다
	public static void main(String[] args) {
		
		Set set1;
		set1 = new java.util.HashSet();
		
		set1.add("첫번째");
		set1.add("두번째");
		set1.add("세번째");
		set1.add("네번째");
		set1.add("다섯번째");
		
		Iterator ite;
		ite = set1.iterator();
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
		
		Object[] arr = set1.toArray();
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
