package com.bit;

import java.util.*;
import java.util.Map.Entry;

public class Ex01_map{

	public static void main(String[] args) {
		Map map = new TreeMap();
		
		int[] arr = new int[] {1,2,3};
		
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", arr);
		map.put("key4", "value4");
		map.put("key5", null);
		
		// 중복된 key를 추가할 경우 기존 key를 덮어씌어버린다.(수정)
		// put으로 어떤 객체를 넣냐에 따라 에러가 발생할 수도 있다. -> 수정 기능이 따로 마련되어있다.
		
		System.out.println("size:" + map.size());
		Collection a = map.values();
		
		Iterator ite = a.iterator();
		while(ite.hasNext()) System.out.println(ite.next());
		
//		System.out.println(map.get("key1"));
//		System.out.println(map.get("key2"));
//		System.out.println(map.get("key1"));
//		System.out.println(map.get("key4"));
//		System.out.println(map.get("key3"));
	
		// 삭제
//		map.remove("key5", null);
		// 수정
//		map.replace("key1", "value1", 30003);
		
		
		// key와 value를 한꺼번에 묶은 객체 -> entry
//		Set entries = map.entrySet();
//		Iterator vite = entries.iterator();
//		while(vite.hasNext()) {
//			Entry entry = (Entry)vite.next();
//			System.out.println(entry.getKey() + ":" + entry.getValue());
//		}
		
		// map 자료구조의 key값을 모두 받기(with Iterator)
//		Set keys = map.keySet();
//		Iterator ite = keys.iterator();
//		while(ite.hasNext()) {
//			Object key = ite.next();
//			System.out.print(key);
//			System.out.print(":");
//			System.out.println(map.get(key));
//		}

	}
}
