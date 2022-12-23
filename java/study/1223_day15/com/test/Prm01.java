package com.test;

import java.util.*;

class Student {
	private String id;
	private int ml;
	private int eng;
	private int math;
	
	public Student(String id, int ml, int eng, int math) {
		this.id = id;
		this.ml = ml;
		this.eng = eng;
		this.math = math;
	}
	
	public String getId() {
		return id;
	}
	
	public int getMl() {
		return ml;
	}
	
	public int getEng() {
		return eng;
	}
	
	public int getMath() {
		return math;
	}
	
	public void setMl(int score) {
		this.ml = score;
	}
	public void setEng(int score) {
		this.eng = score;
	}
	public void setMath(int score) {
		this.math = score;
	}
	
	public int getSum() {
		return ml+eng+math;
	}
	
	public double getAvg() {
		return (int)(this.getSum()*100 / 3.0) * 0.01;
	}
	
	public String getGrade() {
		int sum = this.getSum();
		if(3*90 <= sum && sum <= 3*100) return "A";
		else if(3*80 <= sum && sum < 3*90) return "B";
		else if(3*70 <= sum && sum < 3*80) return "C";
		else if(3*60 <= sum && sum < 3*70) return "D";
		else return "F";
	}
	
}

public class Prm01 {

	static Map DataSet = new HashMap();
	
	public static void main(String[] args) {
		System.out.println("학생성적관리프로그램 ver0.3.0");
		String select;
		
		while(true) {
			java.util.Scanner sc = new java.util.Scanner(System.in);
			System.out.print("1.리스트    2.입력    3.수정    4.삭제    5.상세보기    0.종료    >");
			select = sc.nextLine();
			if(select.equals("0")) {
				System.out.println("학생성적관리프로그램 종료");
				return;
			}else if(select.equals("1")) {
				Set data = DataSet.keySet();
				System.out.println("----------------------------리스트----------------------------");
				System.out.println("학번\t국어\t영어\t수학");
				
				Collection list = DataSet.values();
				Iterator ite = list.iterator();
				while(ite.hasNext()) {
					Student stu = (Student)ite.next();
					System.out.println(stu.getId() + "\t" + stu.getMl() + "\t" + stu.getEng() + "\t" + stu.getMath());
				}
				System.out.println("------------------------------------------------------------");
			}else if(select.equals("2")) {
				String id;
				int ml, eng, math;
				while(true) {	
					System.out.print("학번> ");
					id = sc.nextLine();
					if(DataSet.get(id) == null) {
						break;
					}
					System.out.println("이미 존재하는 학번입니다! 다시 입력해주세요!");
				}
				System.out.print("국어> ");
				ml = sc.nextInt();
				System.out.print("영어> ");
				eng = sc.nextInt();
				System.out.print("수학> ");
				math = sc.nextInt();
				DataSet.put(id, new Student(id, ml, eng, math));
				System.out.println();
			}else if(select.equals("3")) {
				String id;
				int ml, eng, math;
				System.out.print("학번 > ");
				id = sc.nextLine();
				if(DataSet.containsKey(id)) {
					Student stu = (Student)DataSet.get(id);
					System.out.print("국어> ");
					ml = sc.nextInt();
					stu.setMl(ml);
					System.out.print("영어> ");
					eng = sc.nextInt();
					stu.setEng(eng);
					System.out.print("수학> ");
					math = sc.nextInt();
					stu.setMath(math);
					DataSet.replace(id, stu);
					System.out.println("수정완료!");
				}else {
					System.out.println("존재하지 않는 학번입니다!");
				}					
			}else if(select.equals("4")) {
				String id;
				System.out.print("학번 >");
				id = sc.nextLine();
				if(DataSet.get(id) != null) {
					DataSet.remove(id);
					System.out.println("삭제완료!");
				}else {
					System.out.println("존재하지 않는 학번입니다!");
				}
			}else if(select.equals("5")) {
				String id;
				int sum = 0;
				double tAvg = 0.0;
				Set total = DataSet.keySet();
				Iterator ite = total.iterator();
				while(ite.hasNext()) {
					String tid = (String)ite.next();
					Student stu = (Student)DataSet.get(tid); 
					sum += stu.getAvg();
				}
				tAvg = (int)(sum*100 / (float)(DataSet.size())) * 0.01;
				System.out.print("학번> ");
				id = sc.nextLine();
				System.out.println("-------------------------------------------");
				if(DataSet.get(id) != null) {
					Student stu = (Student)DataSet.get(id);
					System.out.println("과목합계: "+ stu.getSum());
					System.out.println("과목평균(학생평균/전체평균): "+ stu.getAvg() + " / " + tAvg);
					System.out.println("학      점: "+ stu.getGrade());
					
				}else {
					System.out.println("존재하지 않는 학번입니다!");
				}
				System.out.println("-------------------------------------------");		
			}
		}
	}
}
