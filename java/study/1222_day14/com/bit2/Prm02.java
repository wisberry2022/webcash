package com.bit2;

import java.util.*;

class Student {
	int id;
	int ml;
	int eng;
	int math;
	
	public Student(int id, int ml, int eng, int math) {
		this.id = id;
		this.ml = ml;
		this.eng = eng;
		this.math = math;
	}
	
	public int getSum() {
		return ml+eng+math;
	}
	
	public double getAvg() {
		return (int)((this.getSum()*100) / 3.0) * 0.01; 
	}
	
	public String getGrade() {
		int sum = this.getSum();
		if(3*90 <= sum && sum <= 3*100) return "A";
		else if(3*80 <= sum && sum < 3*90) return "B";
		else if(3*70 <= sum && sum < 3*80) return "C";
		else if(3*60 <= sum && sum < 3*70) return "D";
		else return "F(재수강 요망)";
	}
	
	public void modify(int ml, int eng, int math) {
		this.ml = ml;
		this.eng = eng;
		this.math = math;
	}
	
}

public class Prm02 {
	static ArrayList DataSet = new ArrayList();
	
	public static void main(String[] args) {
		// 학생성적관리프로그램(ver 0.4.0);
		// 1.리스트    2.입력    3.수정    4.삭제    5.상세보기 0.종료
		// 국어 영어 수학
		System.out.println("학생성적관리프로그램 ver0.4.0");
		String select;
		java.util.Scanner sc = new java.util.Scanner(System.in);
		while(true) {
			System.out.print("1.리스트    2.입력    3.수정    4.삭제    5.상세보기    0.종료     > ");
			select = sc.nextLine();
			if(select.equals("0")) {
				System.out.println("학생성적관리프로그램 종료");
				return;
			}else if(select.equals("1")) {
				Show();
			}else if(select.equals("2")) {
				InputData();
			}else if(select.equals("3")) {
				modifyData();
			}else if(select.equals("4")) {
				removeData();
			}else if(select.equals("5")) {
				DetailShow();
			}else {
				System.out.println("0에서 5까지의 숫자를 입력해주세요!");
			}
		}

	}

	// 리스트
	public static void Show() {
		System.out.println("-----------------------------------리스트-----------------------------------");
		System.out.println("학번\t국어\t영어\t수학");
		for(int i = 0; i<DataSet.size(); i++) {
			Student data = (Student)DataSet.get(i);
			System.out.println(data.id + "\t" + data.ml + "\t" + data.eng + "\t" + data.math + "\t");
		}
		System.out.println("--------------------------------------------------------------------------");
	}
	
	// 입력
	public static void InputData() {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int ml, eng, math;
		int id;
		boolean isFinish = false;
		
		System.out.print("학번>");
		id = sc.nextInt();
		System.out.print("국어>");
		ml = sc.nextInt();
		System.out.print("영어>");
		eng = sc.nextInt();
		System.out.print("수학>");
		math = sc.nextInt();
		DataSet.add(new Student(id, ml, eng, math));
		isFinish = true;
	}
	
	// 데이터 수정
	public static void modifyData() {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		System.out.print("학번을 입력하세요! >  ");
		
		int id = sc.nextInt();
		int ml, eng, math;
		
		for(int i = 0; i<DataSet.size(); i++) {
			Student detail = (Student)DataSet.get(i);
			if(detail.id == id) {
				System.out.print("국어> ");
				ml = sc.nextInt();
				System.out.print("영어> ");
				eng = sc.nextInt();
				System.out.print("수학> ");
				math = sc.nextInt();
				detail.modify(ml, eng, math);
				break;
			}
		}
	}
	
	// 데이터 삭제
	public static void removeData() {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print("학번을 입력하세요! >  ");
		int id = sc.nextInt();
		
		for(int i = 0; i<DataSet.size(); i++) {
			Student data = (Student)DataSet.get(i);
			if(data.id == id) {
				DataSet.remove(i);
				System.out.println("삭제완료!");
				return;
			}
		}
		System.out.println("일치하는 학번이 없습니다!");	
	}
	

	// 상세보기
	public static void DetailShow() {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		
		System.out.print("학번을 입력하세요! >  ");
		int id = sc.nextInt();
		
		// 학생 전체 평균 구하기
		double sum = 0.0;
		int nums = DataSet.size();
		for(int i = 0; i<DataSet.size(); i++) {
			Student detail = (Student)DataSet.get(i);
			sum += detail.getAvg();
		}
		
		double average = (int)((sum*100)/(float)nums)*0.01;
		
		for(int i = 0; i<DataSet.size(); i++) {
			Student detail = (Student)DataSet.get(i);
			if(detail.id == id) {
				System.out.println("-----------------------------------상세보기-----------------------------------");
				System.out.println(detail.id + "번의 상세 성적");
				System.out.println("합계:" + detail.getSum());
				System.out.println("평균:" + detail.getAvg());
				System.out.println("학점:" + detail.getGrade());
				System.out.println("전체학생평균:" + average);
				System.out.println("---------------------------------------------------------------------------");
				break;
			}
		}
		
	}
	

	

}
