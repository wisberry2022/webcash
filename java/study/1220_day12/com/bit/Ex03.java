package com.bit;

public class Ex03 implements Cloneable{
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Object obj = new Object();
		System.out.println(obj.hashCode());
		Ex03 me = new Ex03();
		Object you = me;
		
		Ex03 you2 = (Ex03)you;
		System.out.println(me == you2);
		Ex03 you3 = (Ex03)me.clone();
		System.out.println(me==you3);
		System.out.println(System.currentTimeMillis());
		int[] arr = {1,3,5,7,9};
		// 깊은 복사가 진행됨
		int[] arr2 = arr.clone();
		System.out.println(arr == arr2);
		
		for(int i = 0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
	}

}
