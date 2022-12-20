package com.test;

class LottoBall {
	// 1 ~ 10 	노란색
	// 11 ~ 20	파란색
	// 21 ~ 30	빨간색
	// 31 ~ 40	회   색
	// 41 ~ 45	초록색
	private String color;
	private int num;
	
	public LottoBall(String color) {
		this.color = color;
		this.setColor();
	}
	
	private void setColor() {
		switch(this.color) {
			case "노란": {this.num = (int)(Math.random()*10)+1; break;}
			case "파란": {this.num = (int)(Math.random()*10)+11; break;}
			case "빨간": {this.num = (int)(Math.random()*10)+21; break;}
			case "회   ": {this.num = (int)(Math.random()*10)+31; break;}
			case "초록": {this.num = (int)(Math.random()*5)+41; break;}
		}
	}
	
	public void show() {
		System.out.println(this.color + "색 " + this.num + "번 입니다!");
	}
	
	public int getNum() {
		return this.num;
	}
}

public class Test3 {
	static final String[] colorSet = new String[] {"초록", "회   ", "빨간", "파란", "노란"};
	private LottoBall BonusBall;
	
	public LottoBall getBonus() {
		return this.BonusBall;
	}
	
	public static void sort(LottoBall[] arr) {
		int cnt = 0;
		while(true) {
			for(int i = 0; i<arr.length; i++) {
				if(i != arr.length-1 && arr[i].getNum() > arr[i+1].getNum()) {
					LottoBall temp = arr[i+1];
					arr[i+1] = arr[i];
					arr[i] = temp;
					cnt++;
				}
			}
			if(cnt == 0) {
				return;
			}
			cnt = 0;			
		}
	}
	
	public LottoBall[] autoPlay() {
		LottoBall[] auto = new LottoBall[6];
		int ridx;
		boolean isDup;
		
		for(int i = 0; i<=auto.length; i++) {
			isDup = false;
			ridx = (int)(Math.random() * 5);
			LottoBall ball = new LottoBall(Test3.colorSet[ridx]);
			for(int j = 0; j<i; j++) {
				if(auto[j].getNum() == ball.getNum()) {
					i--;
					isDup = true;
					break;
				}
			}
			if(!isDup && i<auto.length) {
				auto[i] = ball;
			}else if(i == auto.length) {
				this.BonusBall = ball;
			}
		}
		
		Test3.sort(auto);
		return auto;
	}
	
	public static void main(String[] args) {
		System.out.println("SAT. 20시 40분   제990회 MBC LOTTO 추첨 ver0.2.0");
		
		java.util.Scanner sc;
		sc = new java.util.Scanner(System.in);
		
		while(true) {
			System.out.println("아래 메뉴 중 하나를 고르세요");
			System.out.print("0.로또 안사요    1.번호 자동 추첨    2.수동 번호 추첨>");
			String select = sc.nextLine();
			if(select.equals("0")) {
				System.out.println("추첨이 종료되었습니다! 다음 주 이 시간에...");
				return;
			}else if(select.equals("1")) {	
				Test3 Game = new Test3();
				LottoBall[] my = Game.autoPlay();
				
				System.out.println("====================내꺼====================");
				for(int i = 0; i<my.length; i++) {
					if(i<my.length) {
						System.out.print(i+1 + "번째 공은 ");
						my[i].show();	
					}else {
						System.out.print("보너스 공은 ");
						Game.getBonus().show();
					}
				}
				System.out.println("====================내꺼====================");
				
				LottoBall[] result = Game.autoPlay();
				
				System.out.println("====================결과====================");
				for(int i = 0; i<=result.length; i++) {
					if(i<result.length) {
						System.out.print(i+1 + "번째 공은 ");
						result[i].show();	
					}else {
						System.out.print("보너스 공은 ");
						Game.getBonus().show();
					}		
				}
				System.out.println("====================결과====================");
				return;
			}else if(select.equals("2")) {
				return;
			}else {
				System.out.println("잘못된 메뉴입력입니다! 다시 한 번 입력해주세요!");
			}	
		}
	}

}
