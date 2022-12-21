package com.bit2;

class MyError extends Exception{
	MyError(){
		super("Custom Error");
	}
}

public class Ex13 {
	public static void main(String[] args) {
		try {
			func(4,4);	
		}catch(MyError e) {
			System.out.println("에러받아서 처리");
			e.printStackTrace();
		}
	}
	

	public static void func(int a, int b) throws MyError {
		if(a/b == 1) {
			MyError err = new MyError();
			throw err;
//			ClassNotFoundException err;
//			err = new ClassNotFoundException();	
//			throw err;
		}
		
		int su = a/b;
	}
}
