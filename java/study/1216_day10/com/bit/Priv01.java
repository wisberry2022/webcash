package com.bit;

class DArray {
	int[] arr1 = new int[0];
	
	void add(int num) {
		int[] arr2 = new int[arr1.length+1];
		for(int i = 0; i<arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		arr2[arr2.length-1] = num;
		arr1 = arr2;
	}

	
	void remove(int num) {
		int[] temp = new int[arr1.length-1];
		for(int i = 0; i<arr1.length; i++) {
			if(arr1[i] == num) {
				int[] temp2 = new int[arr1.length - i];
				for(int j = 0; j<temp2.length; j++) {
					temp2[j] = arr1[i+j];
				}
				arr1 = temp2;
				continue;
			}
			temp[i] = arr1[i];
		}
		arr1 = temp;
	}
	
	
	int[] getArr() {
		return this.arr1;
	}
}

public class Priv01 {
	public static void main(String[] args) {
		DArray arr = new DArray();
		
		arr.add(2);
		arr.add(31);
		arr.add(42);
		arr.add(5);
		arr.add(10);
		
		int[] temp = arr.getArr();
		
		for(int i = 0; i<temp.length; i++) {
			System.out.print(temp[i] + " ");
		}
		
		arr.remove(5);
		System.out.println();
		
		temp = arr.getArr();
		
		for(int i = 0; i<temp.length; i++) {
			System.out.print(temp[i] + " ");
		}
		
	}

}
