class Ex04 {
	public static void main(String[] args){
		func01();
		Ex04 me = new Ex04();
		me = new Ex04();
		me.func02();
	}

	public static void func01() {
		System.out.println("Ex04 class - func01 run...");
	}

	public void func02() {
		System.out.println("non-static method func02");
		func01();
	}
}



