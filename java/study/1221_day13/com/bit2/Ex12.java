package com.bit2;

public class Ex12 {
	
	// 예외처리 02
	public static void main(String[] args) {
		int[] arr1 = {-2, -1, 0, 1, 2};

			for(int i = 0; i<6; i++) {
				try {
					System.out.println(3/arr1[i]);	
				}catch(ArithmeticException e) {
					System.out.println(e.toString());
				}catch(ArrayIndexOutOfBoundsException e) {
					System.out.println(e.toString());
				}
			}
	}
}