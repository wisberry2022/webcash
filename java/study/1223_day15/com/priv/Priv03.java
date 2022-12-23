package com.priv;

class Book {
	String name;
	int page;
	
	public Book newInstance() {
		return this;
	}
	
//	private Book() {
//		name = "세상에서 가장 재미없는 책";
//		page = 555;
//	}
	
	int getPage() {
		return page;
	}
	
	String getName() {
		return name;
	}
}

public class Priv03 {

	public static void main(String[] args) throws ClassNotFoundException {
		Class after = Class.forName("Priv02");
		
	}

}
