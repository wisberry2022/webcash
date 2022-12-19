package com.bit;

interface Lec02 {
	int su1 = 1111; 
	public abstract void func01();
	public void func03();
	void func04();
}

interface Lec021 {}

// interface간 상속은 extends로 진행(implements처럼 다중 상속 가능)
interface Lec88 extends Lec02, Lec021 {
	public abstract void func02();
}

public class Ex02 extends Object implements Lec02, Lec88{

	public void func01() {
		System.out.println("자식 기능...");
	}
	
	public void func02() {
		System.out.println("자식 기능2...");
	}
	
	public void func03() {
		System.out.println("자식 기능3...");
	}
	
	public void func04() {
		
	}
	
	public static void main(String[] args) {
		Lec02 me = new Ex02();
		System.out.println(Lec02.su1);
		me.func01();
		
	}

}
