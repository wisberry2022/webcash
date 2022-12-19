package test;

public class test02 {
	public static void main(String[] args) {
		System.out.println("학생성적관리프로그램(0.2.0)");
		java.util.Scanner sc;
		sc = new java.util.Scanner(System.in);
		int input = 0;
//		System.out.print("총원>");
//		input = sc.nextInt();
		int[][] data = new int[input][];
		int cnt = 0;
		
		while(true) {
			System.out.println("1.리스트      2.입력      3.상세보기      4.삭제      0.종료");
			input = sc.nextInt();
			if(input == 0) break;
			else if(input == 1) {
				System.out.println("--------------------------------------");
				System.out.println("학번\tjava\tweb\tframework");
				System.out.println("--------------------------------------");
				for(int i = 0; i<data.length; i++) {
					int[] stu = data[i];
					if(stu == null) {
						System.out.println("학생정보가 없습니다!");
						break;
					}
					System.out.println(stu[0] + "\t" + stu[1] + "\t" + stu[2] + "\t" + stu[3] + "\t");
				}
				System.out.println("--------------------------------------");
			}
			else if(input == 2) {
				int[][] before = data;
				data = new int[data.length+1][];
				System.arraycopy(before, 0, data, 0,  before.length);
				int[] stu = new int[4];
				stu[0] = inputSu("학번");
				stu[1] = inputSu("java>", 100);
				stu[2] = inputSu("web>", 100);
				stu[3] = inputSu("framework>", 100);
				data[cnt++] = stu;
			}
			else if(input == 3) {
				System.out.print("학번>");
				input = sc.nextInt();
				for(int i = 0; i<data.length; i++) {
					int[] stu = data[i];
					if(input == stu[0]) {
						System.out.println("합계: "+(stu[1]+stu[2]+stu[3]));
						System.out.println("평균: "+(stu[1]+stu[2]+stu[3])*100/3/100.0);
						char ch = 'F';
						if((stu[1]+stu[2]+stu[3]) >= 3*90) ch = 'A';
						else if((stu[1]+stu[2]+stu[3]) >= 3*80) ch = 'B';
						else if((stu[1]+stu[2]+stu[3]) >= 3*70) ch = 'C';
						else if((stu[1]+stu[2]+stu[3]) >= 3*60) ch = 'D';
						System.out.println("학점:" + ch);
						break;
					}
				}
			}
			else if(input == 4) {}
		}	
	}
	
	public static int inputSu(String msg) {
		int sum = 0;
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print(msg);
		String input = sc.nextLine();
		boolean boo = true;
		// 문자열 검증
		for(int i = 0; i<input.length(); i++) {
			if(input.charAt(i) < '0' || input.charAt(i) > '9') {
				boo = false;
			}
		}
		if(boo) {
			// 숫자로 구성된 문자열을 숫자로 반환
			int m = 0;
			int n = 1;
			for(int i = input.length()-1; i>=0; i--) {
				for(int j = 0; j<m; j++) {n*=10;}
				sum+=(input.charAt(i) - '0')*n;n=1;m++;
			}
			return sum;
		}else {
			return inputSu(msg);
		}	
	}
	
	public static int inputSu(String msg, int limit) {
		int su = -1;
		while(true) {
			su = inputSu(msg);
			if(su<0 || su>limit) {
				continue;
			}else {
				return su;
			}
		}
	}
}
