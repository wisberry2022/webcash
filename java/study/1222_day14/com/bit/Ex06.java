package com.bit;

import java.util.*;

public class Ex06 {

	// Queue
	public static void main(String[] args) {
		List list;
		list = new ArrayList();
		list = new LinkedList();
		Queue que;
		que = new LinkedList();
		que.offer(1);
		que.offer(2);
		que.offer(3);
		que.offer(4);
		
//		while(que.peek() != null) {
//			System.out.println(que.peek());
//			que.poll();
//		}
		
		while(que.peek() != null) {
			System.out.println(que.poll());
		}
		
//		System.out.println(que.peek());
//		System.out.println(que.peek());
//		System.out.println(que.peek());
//		System.out.println(que.poll());
//		System.out.println(que.poll());
//		System.out.println(que.poll());
		// 더 이상 값을 꺼낼 수 없을 때 special value를 반환
//		System.out.println(que.poll());
	}
}
