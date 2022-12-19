package test;

public class test01 {
	public static void main(String[] args) {
		System.out.println("학생성적관리프로그램(0.2.0)");
		java.util.Scanner sc;
		sc = new java.util.Scanner(System.in);
		int input = 0;
		int cnt = 0;
		int[] data;
//		System.out.print("총원>");
//		input = sc.nextInt();
		data = new int[input*4];
		
		while(true) {
			System.out.println("1.리스트      2.입력      3.상세보기      4.삭제      0.종료");
			input = sc.nextInt();
			if(input == 0) break;
			else if(input == 1) {
				System.out.println("리스트 출력");
				System.out.println("-------------------------------------------");
				System.out.println("학번\tjava\tweb\tframework");
				System.out.println("-------------------------------------------");
				for(int i = 0; i<data.length; i++) {
					System.out.print(data[i++]);
					System.out.print('\t');
					System.out.print(data[i++]);
					System.out.print('\t');
					System.out.print(data[i++]);
					System.out.print('\t');
					System.out.print(data[i]);
					System.out.print('\n');
				}
				System.out.println("-------------------------------------------");
			}
			else if(input == 2) {
				int[] before = data;
				data = new int[data.length+4];
				System.arraycopy(before, 0, data, 0, before.length);
				System.out.print("학번>");
				input = sc.nextInt();
				data[cnt++] = input;
				System.out.print("java>");
				input = sc.nextInt();
				data[cnt++] = input;
				System.out.print("web>");
				input = sc.nextInt();
				data[cnt++] = input;
				System.out.print("framework>");
				input = sc.nextInt();
				data[cnt++] = input;
			}
			else if(input == 3) {
				System.out.print("학번>");
				input = sc.nextInt();
				for(int i=0; i<data.length; i+=4) {
					if(data[i] == input) {
						int sum = data[++i]+data[++i]+data[++i];
						double age = (sum*100)/3/100.0;
						char ch = 'F';
						if(sum>= 3*90) ch = 'A';
						else if(sum >= 3*80) ch = 'B';
						else if(sum >= 3*70) ch = 'C';
						else if(sum >= 3*60) ch = 'D';
						System.out.println(input + "학번 합계:"+sum);
						System.out.println(input + "학번 평균:"+age);
						System.out.println(input + "학번 학점:"+ch);
						break;
					}
				}
			}
			else if(input == 4) {}
		}
		
	}

}
