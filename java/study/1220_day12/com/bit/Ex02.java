package com.bit;

final class Lec03{
	final static int su2 = 2222;
	final int su3 = 3333;
	
	public static void func01(final int su) {
		
	}
	
	public final void func02() {}
}

public class Ex02 {
	
	public void func02() {}
	
	public static void main(String[] args) {
		final int su1 = 1111;
		Lec03.func01(1);
		Lec03.func01(3);

	}

}
