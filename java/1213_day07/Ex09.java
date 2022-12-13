package com.bit;

class Ex09 {
	
	private static Ex09 me = new Ex09();	
	private Ex09() {};

	public static Ex09 newInstance() {
		return me;
	}

	public static void main(String[] args){
		com.bit2.Ex10.func01();
		com.bit2.Ex10 ex;
		ex = new com.bit2.Ex10(1);
	}
}