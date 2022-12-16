package com.test;
import java.util.ArrayList;

public class SubTest {
	static ArrayList<String[]> totalData = new ArrayList<>();
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
					totalData.add(student.split(" "));
					stdIdTable.add(student.split(" ")[0]);
					break;	
				}
			}
		}	
	}
	
	// 1번(리스트)&3번(상세메뉴) 메소드
	public static void List(String menuName, ArrayList<String[]> dataSet) {
		System.out.println("\n=========================="+menuName + "==========================\n");
		if(menuName.equals("리스트")) {
			System.out.println("학번"+"\t\t"+"java"+"\t"+"web"+"\t"+"framework");	
		}else {
			System.out.println("학번"+"\t\t"+"합계"+"\t"+"평균"+"\t"+"학점");
		}
		for(int i = 0; i<dataSet.size(); i++) {
			String[] data = dataSet.get(i);
			for(int j = 0; j<data.length; j++) {
				System.out.print(data[j] + "\t");
			}
			System.out.println();
		}
		System.out.println("\n=======================================================\n");
	}
	
	// 학점 포함한 배열(GradeTable), 학점 미포함한 배열(totalData) 내에 있는 데이터 삭제
	public static void ArrayDelete(ArrayList<String[]> arrData, String id) {
		for(int i = 0; i<arrData.size(); i++) {
			String[] data = arrData.get(i);
			if(data[0].equals(id)) {
				arrData.remove(data);
			}
		}
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
				ArrayDelete(totalData, id);
				ArrayDelete(GradeTable, id);
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
				List("리스트", totalData);
			}else if(mSelect == 2) {
				InputData();
			}else if(mSelect == 3) {
				List("상세정보", GradeTable);
			}else if(mSelect == 4) {
				RemoveData();
			}else {
				System.out.println("잘못된 입력입니다! 0번에서 4번 사이의 숫자를 입력해주세요!");
			}
		}
	}
}