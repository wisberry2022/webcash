class Prc01C {
	public static void main(String[] args){
		boolean boo = true;
		int cnt = 0;
		int gab = 'a'-'A';
		while(boo){
			System.out.print((char)('A'+cnt++));
			if(('A'+cnt-1) == 'Z') boo = false;
		}
	}
}