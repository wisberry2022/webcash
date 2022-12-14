class Prm02 {
	public static void main(String[] args){
		//Q1.
		int i = 65;
		while(true){
			if(i == 90){
				System.out.println((char)i);
				break;
			}
			System.out.print((char)i + ",");
			i++;
		}

		//Q2.
		int j = 65;
		while(true){s
			if(j == 90) {
				System.out.println((char)j + "(" + (char)(j+32) + ")");
				break;
			}
			System.out.print((char)j + "(" + (char)(j+32) + "),");
			j++;
		}

		//Q3.
		int k = 1;
		while(true){
			if(k == 9){
				System.out.println(k);
				break;
			}else if(k % 3 == 1){
				System.out.println();
			}
			System.out.print(k + " ");
			k++;
		}

		//Q4.
		int l = 1;
		int m = 1;
		while(true){
			if(l == 9){
				System.out.println(m);
				break;
			}else if(l % 3 == 1){
				System.out.println();
				m = (l/3)+1;
			}
			System.out.print(m + " ");
			m++;
			l++;
		}
	}
}