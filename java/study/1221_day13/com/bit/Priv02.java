package com.bit;

class DArray {
	int addNum = 0;
	int size;
	int[] arr1;
	
	DArray(int num) {
		arr1 = new int[num];
		size = num;
	}
	
	void add(int num) {
		if(addNum < arr1.length) {
			arr1[addNum++] = num;
		}else {
			int[] copy = new int[arr1.length+1];
			for(int i = 0; i<arr1.length; i++) {
				copy[i] = arr1[i];
			}
			copy[copy.length-1] = num;
			arr1 = copy;	
		}
	}
	
	void remove(int num) {
		int[] copy = new int[arr1.length-1];
		boolean bool = false;
		for(int i = 0; i<arr1.length; i++) {
			if(arr1[i] == num) {
				bool = true;
				continue;
			}else {
				if(bool) {
					copy[i-1] = arr1[i];
				}else {
					copy[i] = arr1[i];		
				}
				
			}
		}
		arr1 = copy;
	}
	
	
	
	int[] getArr() {
		return arr1;
	}
}

public class Priv02 {

	public static void main(String[] args) {
		DArray arr1 = new DArray(2);
		arr1.add(1);
		arr1.add(2);
		arr1.add(4);
		
		int[] iArr = arr1.getArr();
		for(int i = 0; i<iArr.length; i++) {
			System.out.print(iArr[i] + " ");
		}
		
		System.out.println();
		
		arr1.remove(2);
		arr1.remove(1);
		arr1.remove(4);
		
		int[] iArr2 = arr1.getArr();
		for(int i = 0; i<iArr2.length; i++) {
			System.out.print(iArr2[i] + " ");
		}
	}

}
