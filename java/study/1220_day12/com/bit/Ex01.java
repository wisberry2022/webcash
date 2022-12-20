package com.bit;

class Lec02{
	// public > protected >= default > private
	protected int su1;
	
	protected void func01() {
		System.out.println("hello Lec02");
	};
}

public class Ex01 extends com.bit2.Lec22{
	public static void main(String[] args) {
		Lec02 me = new Lec02();
		me.func01();
			
		Ex01 me2 = new Ex01();
		System.out.println(me2.su1);
		me2.func02();
	}

}
