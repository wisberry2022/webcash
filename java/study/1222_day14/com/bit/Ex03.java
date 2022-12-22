package com.bit;

class Node {
	int val;
	Node nxt;
}

class Arr2 {
	Node first;
	int cnt = 0;
	int size() {
		return cnt;
	}
	
	int get(int idx) {
		Node temp = first;
		for(int i = 0; i<idx; i++) {
			temp = temp.nxt;
		}
		return temp.val;
	}
	
	void add(int su) {
		cnt++;
		Node node = new Node();
		node.val = su;
		if(cnt == 1) {
			first = node;
		}else {
			Node temp = first;
			while(true) {
				if(temp.nxt == null) break;
				temp = temp.nxt;
			}
			temp.nxt = node;
		}
	}
}


public class Ex03 {

	public static void main(String[] args) {
		Arr2 arr = new Arr2();
		arr.add(1111);
		arr.add(1112);
		arr.add(1113);
		arr.add(1114);
		
		for(int i = 0; i<arr.cnt; i++) {
			System.out.println(arr.get(i));
		}

	}

}
