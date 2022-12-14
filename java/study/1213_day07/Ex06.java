class Ex06 {
	public int num1 = 10;
	public static int func01(int su) {
		if(su == 0) return 0;
		else return su--+func01(su);		
	}

	public void func02() {
		System.out.println("func02 run..");
	}

	public Ex06 func03() {
		System.out.println("func03 run...");
		return this;
	}

	public void func04() {
		System.out.println("func04 run!");
		this.func05();
	}

	public void func05() {
		System.out.println("func05 run!");
		System.out.println(this);
	}

	public static void main(String[] args) {
		// int sum = func01(5);		
		// System.out.println("3+2+1="+sum);
		Ex06 me = new Ex06();
		Ex06 me2 = me.func03().func03();
		System.out.println("in main method" + me + " " + me2);		
		me2.num1++;
		System.out.println("in main method" + me.num1 + " " + me2.num1);
	}
}