package com.bit;

import java.util.*;


public class Ex07_sort {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		list.add(1111);
		list.add(1112);
		list.add(1115);
		list.add(1114);
		list.add(1113);
		
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		
//		list.sort((a,b) -> {return a-b;});
		
		Iterator<Integer> ite=  list.iterator();
		while(ite.hasNext()) System.out.println(ite.next());

	}

}
