package com.test;

public class Test {

	public static void main(String[] args) {
		System.out.println("로또 번호 생성기 ver0.1.0");
		System.out.println("SAT. MBC  20:40");
		
		System.out.println("번호를 추첨합니다!");
		
		int num;
		int idx = 0;
		int[] lotto = new int[6];
		System.out.println("추첨 시작!");
		// 1 ~ 45 중복되지 않은 랜덤 숫자 추출
		while(idx < 6) {
			boolean isDup = false;
			num = (int)(Math.random()*45);
			for(int j = 0; j<lotto.length; j++) {
				if(lotto[j] == num) {
					isDup = true;
					break;
				}
			}
			if(!isDup) {
				lotto[idx] = num;
				idx++;
			}
		}	
		
		
		System.out.println("추첨 종료!");
		
		System.out.println();
		
		int cnt = 0;
		while(true) {
			for(int i = 0; i<lotto.length; i++) {
				if(i != 5 && lotto[i] > lotto[i+1]) {
					int temp = lotto[i+1];
					lotto[i+1] = lotto[i];
					lotto[i] = temp;
					cnt++;
				}
			}
			if(cnt == 0) {
				break;
			}
			cnt = 0;
		}
		
		for(int i = 0; i<lotto.length; i++) {
			System.out.println(i+1 + "번째 공은" + lotto[i] + "입니다!");
		}
		

	}

}
