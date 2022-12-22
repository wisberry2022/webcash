package com.bit;

import java.util.*;

public class Ex05 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(2222);
		list.add(3);
		ArrayList list2 = new ArrayList(list);
//		list2.addAll(0, list);
		
		list.add(3333);
		
//		for(int i = 0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
//		list2.clear();
		// ArrayList에 들어가는 데이터는 자동으로 Boxing이 된다. ArrayList에 들어가는 데이터의 자료형은 기본적으로 Object이기 때문이다.
		list.remove(new Integer(2222));
		
//		for(int i = 0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
		
		
		// 형변환 필요
		ArrayList list3 = (ArrayList)list.clone();
		
//		System.out.println(list3.contains(3333));
		
		list3.set(2, 135);
		System.out.println(list3);
		
		Object[] arr = list3.toArray();
		
		for(int i = 0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
