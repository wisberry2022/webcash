class Ex03 {
	public static void main(String[] args){
		int su = 1;
		gugu3(su++);
		gugu3(su++);
		gugu3(su++);
		gugu3(su++);
		gugu3(su++);
		gugu3(su++);
		gugu3(su++);
		gugu3(su++);
		gugu3(su++);
	}

	public static void gugu(int su){
		System.out.println(2+"x"+su);
	}

	public static void gugu3(int su){
		System.out.println(3+"x"+su);
	}
}