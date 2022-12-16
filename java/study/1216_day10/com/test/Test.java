package com.test;
import java.util.ArrayList;

public class Test {
	static ArrayList<String> totalData = new ArrayList<>();
	static ArrayList<String[]> GradeTable = new ArrayList<>();
	static ArrayList<String> stdIdTable = new ArrayList<>();
	
	// 평균 점수에 따른 알파벳 학점 반환 메소드
	public static String SetGrade(float average) {
		int criteria = (int)average / 10;
		String result = "F";
		if(9 <= criteria && criteria <= 10) {
			result = "A";
		}else if(8 <= criteria && criteria < 9) {
			result = "B";
		}else if(7 <= criteria && criteria < 8) {
			result = "C";
		}else if(6 <= criteria && criteria < 7) {
			result = "D";
		}else {
			result = "F";
		}
		return result;
	}
	
	// 입력 정보를 바탕으로 점수 합계 및 학점 계산 메소드
	public static void AddGrade(String[] studentData) {
		int sum = 0;
		String average;
		String grade;
		for(int i = 1; i<studentData.length; i++) {
			sum += Integer.parseInt(studentData[i]);
		}
		average = String.format("%.2f",((float)sum / (float)3));
		float fAverage = (float)sum / (float)3;
		grade = SetGrade(fAverage);
		String[] fSet = new String[] {studentData[0], sum+" ", average, grade};
		GradeTable.add(fSet);
	}
	
	// 학번, 과목별 점수를 입력받는 메소드
	public static void InputData() {
		System.out.println("학번, 과목별 점수를  순서대로 입력하세요!(과목 순서 - java, web, framework)");
		System.out.println("입력예시 ex) 20221234 85 85 30");
		while(true) {
			System.out.print(">");
			java.util.Scanner sc = new java.util.Scanner(System.in);
			String student = sc.nextLine();
			// 유효성 체크
			// 입력한 정보가 정해진 형태를 벗어났을 때 (학번, java, web, framework)
			if(student.split(" ").length != 4) {
				System.out.println("\n잘못된 입력입니다! 입력내용을 다시 확인해주세요!");
			}else {
				// 입력한 학번이 기존에 이미 등록한 학번인지 체크
				if(stdIdTable.contains(student.split(" ")[0])) {
					System.out.println("이미 등록한 학번입니다! 다시 확인해주세요!");
				}else {
					// 유효성 체크 이후 데이터에 삽입
					AddGrade(student.split(" "));
					totalData.add(student);
					stdIdTable.add(student.split(" ")[0]);
					break;	
				}
				
			}
		}	
	}
	
	// 1번 메뉴(리스트) 출력 메소드
	public static void List() {
		System.out.println("\n==========================리스트==========================\n");
		System.out.println("학번"+"\t\t"+"java"+"\t"+"web"+"\t"+"framework");
		for(int i = 0; i<totalData.size(); i++) {
			String[] data = totalData.get(i).split(" ");
			for(int j = 0; j<data.length; j++) {
				System.out.print(data[j] + "\t");
			}
			System.out.println();
		}
		System.out.println("\n==========================리스트==========================\n");
	}
	
	// 3번 메뉴(상세정보) 출력 메소드
	public static void DetailList() {
		System.out.println("\n==========================상세보기==========================\n");
		System.out.println("학번"+"\t\t"+"합계"+"\t"+"평균"+"\t"+"힉점");
		for(int i = 0; i<GradeTable.size(); i++) {
			String[] data = GradeTable.get(i);
			for(int j = 0; j<data.length; j++) {
				System.out.print(data[j] + "\t");
			}
			System.out.println();
		}
		System.out.println("\n==========================상세보기==========================\n");
	}
	
	// 4번 메뉴(삭제) 메소드
	public static void RemoveData() {
		System.out.println("학번 목록입니다! 삭제하고 싶은 학번을 콘솔에 입력하세요!");
		for(int i = 0; i<stdIdTable.size(); i++) {
			System.out.println(stdIdTable.get(i) + "\t");
		}
		System.out.println("\n=============================================================");
		System.out.print(">");
		
		while(true) {
			java.util.Scanner sc = new java.util.Scanner(System.in);
			String id = sc.nextLine();
			
			if(stdIdTable.contains(id)) {
				for(int i = 0; i<GradeTable.size(); i++) {
					String[] data = GradeTable.get(i);
					if(data[0].equals(id)) {
						GradeTable.remove(data);
					}
				}
				
				for(int i = 0; i<totalData.size(); i++) {
					String[] data = totalData.get(i).split(" ");
					if(data[0].equals(id)) {
						totalData.remove(totalData.get(i));
					}
				}
				
				stdIdTable.remove(id);
				System.out.println("삭제 완료하였습니다!");
				break;
			}else {
				System.out.println("입력한 학번은 없는 학번입니다! 다시 입력해주세요!");
			}
		}
		
	}
	
	public static void main(String[] args) {
		// 학생 성적 관리프로그램
		System.out.println("학생성적관리프로그램(0.2.0)");
				
		while(true) {
			System.out.println("1.리스트      2.입력       3.상세보기      4.삭제        0.종료>");
			java.util.Scanner sc = new java.util.Scanner(System.in);
			int mSelect = sc.nextInt();
			if(mSelect == 0) {
				System.out.println("학생관리성적프로그램 종료");
				return;
			}else if(mSelect == 1) {
				List();
			}else if(mSelect == 2) {
				InputData();
			}else if(mSelect == 3) {
				DetailList();
			}else if(mSelect == 4) {
				RemoveData();
			}else {
				System.out.println("잘못된 입력입니다! 0번에서 4번 사이의 숫자를 입력해주세요!");
			}
		}
	}

}
