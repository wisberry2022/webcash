package com.bit;

class AutoLottery{
	private int[][] numSet = new int[5][6];
	private LottoNum[] Auto= new LottoNum[45];
	
	public AutoLottery() {
		for(int i = 1; i<=45; i++) {
			Auto[i-1] = new LottoNum();
		}
	}
	
	private void _sort(int idx) {
		for(int i = 0; i<numSet[idx].length-1; i++) {
			for(int j = i+1; j<numSet[idx].length; j++) {
				if(numSet[idx][i] > numSet[idx][j]) {
					int temp = numSet[idx][j];
					numSet[idx][j] = numSet[idx][i];
					numSet[idx][i] = temp;
				}
			}
		}	
	}
	
	public void input() {
		for(int i = 0; i<numSet.length; i++) {	
			for(int j = 0; j<numSet[i].length; j++) {
				int rand = (int)(Math.random()*45)+1;
				if(!Auto[rand-1].marking) {
					Auto[rand-1].marking = true;
					numSet[i][j] = Auto[rand-1].num;
				}else {
					j--;
				}
			}
		}
	}
	
	public void show() {
		for(int i = 0; i<5; i++) {
			_sort(i);	
		}
		char[] alphas = new char[] {'A','B','C','D','E'};
		System.out.println("---------------------------------------------------");
		for(int i = 0; i<numSet.length; i++) {
			System.out.println(alphas[i] + " 자    동 " + "\t" + numSet[i][0] + "\t" + numSet[i][1] + "\t" + numSet[i][2] + "\t" + numSet[i][3] + "\t" + numSet[i][4] + "\t" + numSet[i][5]);
		}
		System.out.println("---------------------------------------------------");
	}
}

class LottoNum {
	private static int cnt = 1;
	final int num;
	boolean marking = false;
	
	LottoNum() {
		num = cnt++;
	}
}

public class Priv01 {
	public static void main(String[] args) {
		System.out.println("LOTTO ver0.2.0");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int select;
		while(true) {
			try {
				System.out.print("0.로또 안 사요        1.자동 추첨        2.수동 추첨");
				select = sc.nextInt();
				if(select == 0) {
					System.out.println("로또 안 살래요!");
					return;
				}else if(select == 1) {
					AutoLottery Game = new AutoLottery();
					Game.input();
					Game.show();			
				}				
			}catch(Exception e) {
				System.out.println("0에서 3까지의 숫자만 입력할 수 있습니다!");
			}
		}
	}

}
