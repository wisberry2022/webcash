class Ex03 {
	public static void main(String[] args){
		int[] iArr = new int[5];
		iArr[0] = 1;
		iArr[1] = iArr[0];
		iArr[2] = 3;
		iArr[3] = 4;
		iArr[4] = 5;
		System.out.println(iArr[1]);
	}
}