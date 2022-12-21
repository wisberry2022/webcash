package com.bit;

class Ball {
	// 1 ~ 10 	노란색
	// 11 ~ 20	파란색
	// 21 ~ 30	빨간색
	// 31 ~ 40	회   색
	// 41 ~ 45	초록색
	private static int cnt= 0;
	final int num;
	boolean marking;
	String color;
	
	Ball() {
		cnt++;
		num = cnt;
		if(cnt<11) color = "노랑";
		else if(cnt<21) color = "파랑";
		else if(cnt<31) color = "빨강";
		else if(cnt<41) color = "검정";
		else color = "초록";
	}
}

public class Test02C {

	public static void main(String[] args) {
		int limit = 45;
		Ball[] box = new Ball[limit];
		String[] note = new String[7];
		
		for(int i = 0; i<box.length; i++) {
			box[i] = new Ball();
		}
		
		int cnt = 0;
		while(true) {
			int ran = 0;
			ran = (int)(Math.random()*limit);
			Ball ball = box[ran];
			if(!ball.marking) {
				note[cnt++] = ball.color + "색 공" + ball.num + "번";
				ball.marking = true;
			}
			if(cnt == note.length) break;			
		}
		
		for(int i = 0; i<6-1; i++) {
			for(int j=i+1; j<6; j++) {
				int before = Integer.parseInt(note[i].replace("번", "").substring(note[i].indexOf("색 공")+"색 공".length()));
				int after = Integer.parseInt(note[j].replace("번", "").substring(note[j].indexOf("색 공")+"색 공".length()));
				if(before > after) {
					String temp = note[i];
					note[i] = note[j];
					note[j] = temp;
				}
			}
		}
		
		for(int i=0; i<note.length; i++) {
//			String num = note[i].replace("번", "")
//					.substring(note[i].indexOf("색 공")+"색 공".length());
//			
//			System.out.println(Integer.parseInt(num));
			System.out.println(note[i]);
		}
	}

}
