package test;

public class test05 {
	public static void main(String[] args) {
		System.out.println("학생성적관리프로그램(0.2.0)");
		java.util.Scanner sc;
		sc = new java.util.Scanner(System.in);
		int input = 0;
		
		while(true) {
			System.out.println("1.리스트      2.입력      3.상세보기      4.삭제      0.종료");
			input = sc.nextInt();
			if(input == 0) break;
			else if(input == 1) {
				System.out.println("리스트 출력");
			}
			else if(input == 2) {
				System.out.print("학번>");
				input = sc.nextInt();
				System.out.print("java>");
				input = sc.nextInt();
				System.out.print("web>");
				input = sc.nextInt();
				System.out.print("framework>");
				input = sc.nextInt();
			}
			else if(input == 3) {
				System.out.print("학번>");
				input = sc.nextInt();
				System.out.println(input + "학번의 합계, 평균, 학점");
			}
			else if(input == 4) {}
		}
		
	}

}
