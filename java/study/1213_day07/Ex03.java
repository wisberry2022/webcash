class Lec03 {
	public final int su2;
	public Lec03() {
		su2 = 2222;
		System.out.println("객체 생성!" + su2);

	}
	public Lec03(int su) {
		su2 = su;		
		System.out.println("객체 생성"+su2);
	}	
}

class Ex03 {
	// public Ex03() {} => 생략되어있다. 
	public static void main(String[] args){
		Lec03 you; // 0x0000 ~ 0xffff
		you = new Lec03(1111);
		System.out.println(you);				
	}
}