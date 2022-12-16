package com.bit;

public class Priv02 {

	public static void main(String[] args) {
		int[] arr1 = new int[] {3,4,5};
		int[] arr2 = new int[] {4,5};
		
		for(int i = 0; i<arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		
		System.out.println();
		
		arr1 = arr2;
		
		for(int i = 0; i<arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
		
		System.out.println();
		
		arr2 = new int[] {10,20,30};
//		arr1[1] = 10;
		
		for(int i = 0; i<arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}

	}

}
