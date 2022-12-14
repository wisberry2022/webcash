class Prm01C2 {
	public static void main(String[] args){
		int su1 = 1;
		int su2 = 4;
		int su3 = 7;
		for(int i = 1; i<=su3; i++){
			System.out.print(i+" ");
			if(i==su2&&i!=su3){
				i-=3;
				su2++;
				System.out.println();
			}
		}
	}
}