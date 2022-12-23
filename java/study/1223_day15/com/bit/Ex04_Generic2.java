package com.bit;

interface Ball {
	public void play();
}

class BaseBall implements Ball {
	String msg;
	
	BaseBall(){
		msg = "거친 실밥이  박혀있는 ";
	}
	
	public void play() {
		System.out.println(msg + "공을 던지고 놉니다");
	}
}

class Lotto implements Ball {
	String msg;
	
	Lotto(int su) {
		msg = su + "번";
	}
	
	public void play() {
		System.out.println(msg + "입니다");
	}
}

class Box<T>{
	T su;
	
	void setSu(T su) {
		this.su = su;
	}
	
	T getSu() {
		return su;
	}
}

public class Ex04_Generic2 {

	public static void main(String[] args) {
		BaseBall bBall = new BaseBall();
		Lotto ball = new Lotto(3);
		Box<Lotto> box = new Box<Lotto>();
		box.setSu(ball);
		
		Lotto su = box.getSu();
		su.play();
		
		Box<BaseBall> box2 = new Box<BaseBall>();
		box2.setSu(bBall);
		
		BaseBall su2 = box2.getSu();
		su2.play();
		
		Box<Ball> box3 = new Box<Ball>();
		box3.setSu(bBall);
		Ball su3 = box3.getSu();
		su3.play();
		box3.setSu(ball);
		Ball su4 = box3.getSu();
		su4.play();
		

	}

}
