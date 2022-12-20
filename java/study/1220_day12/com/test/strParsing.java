package com.test;

public class strParsing {

	public static void main(String[] args) {
		System.out.println("학생성적관리프로그램(0.2.0)");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		String select;
		String students = "";
		while(true) {
			System.out.print("1.리스트    2.입력    3.상세보기    4.삭제    0.종료  >>");
			select = sc.nextLine();
			if(select.equals("1")) {
				String[] datas = students.split("\n");
				System.out.println("=======================리스트=======================");
				System.out.println("학번\tjava\tweb\tframework");
				for(int i = 0; i<datas.length; i++) {
					String[] data = datas[i].split("\t");
					System.out.println(data[0] + "\t" + data[1] + "\t" + data[2] + "\t" + data[3]);
				}
				System.out.println("==================================================");
				
			}else if(select.equals("2")) {
				System.out.print("학번>");
				students += sc.nextLine() + "\t";
				System.out.print("java>");
				students += sc.nextLine() + "\t";
				System.out.print("web>");
				students += sc.nextLine() + "\t";
				System.out.print("framework>");
				students += sc.nextLine() + "\n";
				
			}else if(select.equals("3")) {
				
				System.out.println("학번을 입력하세요>");
				String id = sc.nextLine();
				String[] datas = students.split("\n");
				int sum = 0;
				int java, web, framework;
				double average = 0.0;
				
				char grade = 'F';
				for(int i = 0; i<datas.length; i++) {
					String[] data = datas[i].split("\t");
					if(data[0].equals(id)) {
						java = strToInt(data[1]);
						web= strToInt(data[2]);
						framework= strToInt(data[3]);
						sum = java + web + framework;
						average = ((sum*100) / 3.0)*0.01;
						if(sum >= 3*90) grade = 'A';
						else if(sum >= 3*80) grade = 'B';
						else if(sum >= 3*70) grade = 'C';
						else if(sum >= 3*60) grade = 'D';
						else grade = 'F';
					}
				}
				System.out.println("=======================상세보기=======================");
				System.out.println("학번\t점수합계\t평균(개인평균/전체평균)\t학점");
				System.out.println(id + "\t" + sum + "\t" + average + "\t" + grade);
				System.out.println("===================================================");
			}else if(select.equals("4")) {
				System.out.print("삭제하고 싶은 학번을 입력하세요>");
				String id = sc.nextLine();
				String[] datas = students.split("\n");
				for(int i = 0; i<datas.length; i++) {
					String[] data = datas[i].split("\t");
					if(data[0].equals(id)) {
						
					}
				}
			}else if(select.equals("0")) {
				System.out.println("학생성적관리프로그램 종료");
				return;
			}else {
				System.out.println("잘못된 입력입니다! 숫자 0에서 4사이의 숫자를 입력해주세요!");
	
			}
		}
	}
	
	public static int strToInt(String score) {
		int numScore = 0;
		for(int i = 0; i<score.length(); i++) {
			int num = score.charAt(i) - '0';
			int n = 1;
			for(int j = score.length()-1; j>i; j--) {
				n *= 10;
			}
			numScore = (n*num)+numScore;
		}
		
		return numScore;
	}

}
