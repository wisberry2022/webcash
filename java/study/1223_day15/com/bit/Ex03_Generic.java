package com.bit;

import java.util.*;

public class Ex03_Generic {

	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(12);
		arr.add(13);
		arr.add(14);
		arr.add(15);
		
		for(int i = 0; i<arr.size(); i++) {
			int obj = arr.get(i);
			System.out.println(obj + "입니다");
		}

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("key", 3);
		
		
		List<Object> arr2 = new ArrayList<Object>();
	}

}
