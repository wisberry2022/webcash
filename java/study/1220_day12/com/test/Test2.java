package com.test;

public class Test2 {
	public static void main(String[] args) {
		int[] lottos = new int[6];
		int ridx;
		boolean isDup;
		// 1~45 사이 로또 번호 출력 후 lottos 배열에 차례대로 삽입
		for(int i = 0; i<lottos.length; i++) {
			isDup = true;
			ridx = (int)(Math.random()*45)+1;
			for(int j = 0; j<i; j++) {
				if(lottos[j] == ridx) {
					i--;
					isDup = false;
					break;
				}	
			}
			if(isDup) {
				lottos[i] = ridx;	
			}
		}
				
		System.out.println("추첨종료!");
		int cnt = 0;
		while(true) {
			for(int i = 0; i<lottos.length; i++) {
				if(i != 5 && lottos[i] > lottos[i+1]) {
					int temp = lottos[i+1];
					lottos[i+1] = lottos[i];
					lottos[i] = temp;
					cnt++;
				}
			}
			if(cnt == 0) {
				break;
			}
			cnt = 0;
		}
		
		
		for(int i = 0; i<lottos.length; i++) {
			System.out.println(i+1 + "번째 공은" + lottos[i] + "입니다!");
		}
	}

}
