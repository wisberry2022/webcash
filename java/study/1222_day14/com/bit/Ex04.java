package com.bit;
import java.util.ArrayList;
import java.util.LinkedList;


public class Ex04 {

	public static void main(String[] args) {
		long before = System.currentTimeMillis();
		ArrayList arr = new ArrayList();
//		LinkedList arr = new LinkedList();
		for(int i = 0; i<100000000; i++) {
			arr.add(1111);
			for(int j = 0; j<arr.size(); j++) {
				Object obj = arr.get(i);
			}
		}
		
		long after = System.currentTimeMillis();
		
		System.out.println(after - before);

	}

}
