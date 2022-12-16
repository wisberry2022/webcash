package com.bit;

class Stu{
	
}

class Arr{
	private int[] arr = new int[0];
	
	void removeItem(int item) {
		int idx = -1;
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] == item) {
				idx = i;
				break;
			}
		}
		
		if(idx!=-1) {
			remove(idx);
		}
	}
	
	// 삭제
	void remove(int idx) {
		int[] arr2 = new int[arr.length-1];
		////
		for(int i = 0; i<idx; i++) {
			arr2[i] = arr[i];
		}
		//// 뒷부분 복사
		for(int i = idx+1; i<arr.length; i++) {
			arr2[i-1] = arr[i];
		}
		arr = arr2;
	}
		
	// 추가
	void add(int su) {
		int[] arr2 = new int[arr.length+1];	// arr1 배열보다 +1 size를 가지는 arr2 생성
		for(int i = 0; i<arr.length; i++) {
			arr2[i] = arr[i];	
		}
		arr2[arr2.length-1] = su;
		arr = arr2;
	}
	
	int size() {
		return arr.length;
	}
	
	int get(int index) {
		return arr[index];
	}
}

public class DynamicAlloc {
	public static void main(String[] args) {
		Arr arr = new Arr();
		arr.add(1111);
		arr.add(1112);
		arr.add(1113);
		arr.add(1114);
		arr.add(1115);
		arr.removeItem(1114);
//		arr.remove(1);
		for(int i = 0; i<arr.size(); i++) {
			System.out.print(arr.get(i) + " ");	
		}
	}

}
