class Prm01 {
	public static void main(String[] args){
		//65 ~ 90
		//Q1.
		String msg = "";
		for(int i = 65; i<=90; i++){
			if(i == 90){
				msg += (char)(i);
			}else {
				msg += (char)(i) + ", ";
			}
		}

		System.out.println(msg);

		//65 ~ 90 | 97 ~ 122
		//Q2.
		String msg2 = "";
		for(int i = 65; i<=90; i++){
			if(i == 90) {
				msg2 += (char)(i) + "(" + (char)(i+32) + ")";
			}else {
				msg2 += (char)(i) + "(" + (char)(i+32) + "), ";
			}
		}

		System.out.println(msg2);

		//Q3.
		for(int i = 1; i<=9; i++){
			if(i % 3 == 1){
				System.out.println();
			}
			System.out.print(i + " ");
		}

		System.out.println("\n");

		//Q4.
		for(int i=0; i<3; i++){
			for(int j=1; j<=3; j++){
				System.out.print(j+i + " ");
			}
			System.out.println();
		}

		//Q5.
		for(int i=1; i<=9; i++){
			if(i % 3 == 1){
				System.out.println("\n");
			}
			System.out.print("■" + " ");
		}
	}
}