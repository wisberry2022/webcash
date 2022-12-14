class Ex05 {
	public static int su1;
	public int su2=2222;

	public void func01() {
		System.out.println(su2);
	}

	public static void main(String[] args){
		Ex05 me;
		for(int i = 0; i<5; i++){
			me = new Ex05();
			me.su2++;
			me.func01();
		}
	}
}