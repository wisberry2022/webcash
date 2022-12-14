class Prm01 {
	public static void main(String[] args) {
		// Q1.
		for(int i = 1; i<=4; i++){
			for(int j = 1; j<=i; j++){
				System.out.print("★ ");
			}
			System.out.println();
		}

		System.out.println();

		//Q2.
		for(int i = 1; i<=4; i++){
			for(int j = 1; j<=i; j++){
				System.out.print(j + " ");
			}
			System.out.println();
		}


		System.out.println();

		//Q3.
		int term = 1;
		int cnt = 2;
		for(int i = 1; i<=10; i++){
			System.out.print(i + " ");
			if(term == i) {
				System.out.println();
				term += cnt;
				cnt++;
			}
		}

		System.out.println();

		//Q3-1.
		for(int i = 1; i <= 10; i++){
			System.out.print(i + " ");
			if(i == 1 || i == 3 || i == 6 || i == 10){
				System.out.println();
			}
		}


		System.out.println();

		//Q4.
		for(int i = 4; i>=1; i--){
			for(int j = 1; j<=i; j++){
				System.out.print("★ ");
			}
			System.out.println();
		}

		System.out.println();

		//Q5.
		for(int i = 1; i<=4; i++){
			for(int j = 4; j>=1; j--){
				if(j <= i) {
					System.out.print("★ ");
				}else {
					System.out.print("   ");
				}
			}
			System.out.println();
		}
	}
}