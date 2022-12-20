package com.test;

class Arr{
	private Object[] arr = new Object[0];
	
	void removeItem(Object item) {
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
		Object[] arr2 = new Object[arr.length-1];
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
	void add(Object su) {
		Object[] arr2 = new Object[arr.length+1];	// arr1 배열보다 +1 size를 가지는 arr2 생성
		for(int i = 0; i<arr.length; i++) {
			arr2[i] = arr[i];	
		}
		arr2[arr2.length-1] = su;
		arr = arr2;
	}
	
	int size() {
		return arr.length;
	}
	
	Object get(int index) {
		return arr[index];
	}
}
