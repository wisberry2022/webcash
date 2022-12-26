package com.bit;

interface Inter2 {
	void func();
}

public class Ex06_anonynous_class2 {

	Inter2 obj = new Inter2() {
		public void func() {
			System.out.println("hi my name is anonymous class X-)");
		}
	};
	
	public static void main(String[] args) {
		(new Inter2() {
			public void func() {
				System.out.println("hi my name is anonymous class X-)");
			}
		}).func();
		
		
		Ex06_anonynous_class2 me = new Ex06_anonynous_class2(); 
		me.obj.func();
	}

}
