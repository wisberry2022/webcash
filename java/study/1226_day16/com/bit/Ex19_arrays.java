package com.bit;

import java.util.*;

public class Ex19_arrays {

	public static void main(String[] args) {
		String[] arr1 = {
				"java"
				,"DB"
				,"Web"
				,"framework"
		};
		
		String[] arr2 = Arrays.copyOf(arr1, arr1.length-1);
		// 배열 중 일부 원소만 복사
		String[] arr3 = Arrays.copyOfRange(arr1, 1, arr1.length-1);
		arr1[1] = "database";
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		
		int[] arr4 = new int[3];
		Arrays.fill(arr4, 1234);
		int[] arr5 = {1234, 1234, 1234};
		System.out.println(Arrays.toString(arr4));
		System.out.println(Arrays.equals(arr4, arr5));
		
		int[] lotto = {45, 3, 26, 7, 25, 31};
		Arrays.sort(lotto);
		System.out.println(Arrays.toString(lotto));
		
		System.out.println(Arrays.binarySearch(lotto, 26));
		
		List<Integer> list = Arrays.asList(45,3,26,7,25,31);
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		func(2,3,4,5,6,7,9,10);
	}
	
	public static void func(int ... a) {
		System.out.println(Arrays.toString(a));
	}	
}
