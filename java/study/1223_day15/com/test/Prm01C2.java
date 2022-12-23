package com.test;

import java.util.*;

class Stud implements Comparable<Stud> {
	int num;
	int kor, eng, math;
	
	@Override
	public int compareTo(Stud o) {
		// TODO Auto-generated method stub
		return o.num - num;
	}
}

public class Prm01C2 {
	public static void main(String[] args) {
		Set<Stud> data = new TreeSet<Stud>();
		System.out.println("학생성적관리프로그램 ver 0.4.0");
		Scanner sc = new Scanner(System.in);
		int input = -1;
		
		while(true) {
			System.out.print("1.리스트    2.보기    3.입력    4.삭제    0.종료    >");
			try {
				input = sc.nextInt();	
			}catch(Exception e) {
				System.out.println("숫자로 입력바랍니다");
				sc = new Scanner(System.in);
				continue;
			}
			if(input == 0) break;
			else if(input == 1) {
				System.out.println("------------------------------------------");
				System.out.println("학번\t국어\t영어\t수학");
				System.out.println("------------------------------------------");
				Iterator<Stud> ite = data.iterator();
				while(ite.hasNext()) {
					Stud stu = ite.next();
					System.out.println(stu.num + "\t" + stu.kor + "\t" + stu.eng + "\t" + stu.math);
				}
				System.out.println("------------------------------------------");
			}else if(input == 2) {
				System.out.println("보기");
			}else if(input == 3) {
				Stud stu = new Stud();
				System.out.print("학번> ");
				stu.num = sc.nextInt();
				System.out.print("국어> ");
				stu.kor = sc.nextInt();
				System.out.print("영어> ");
				stu.eng = sc.nextInt();
				System.out.print("수학> ");
				stu.math = sc.nextInt();
				data.add(stu);
			}else if(input == 4) {
				System.out.println("학번");
				input = sc.nextInt();
				Iterator<Stud> ite = data.iterator();
				while(ite.hasNext()) {
					Stud stu = ite.next();
					if(stu.num == input) {
						data.remove(stu);
						break;
					}
				}
			}else {
				System.out.println("입력메뉴를 다시 확인하세요");
			}
		}
		
		System.out.println("이용해주셔서 감사합니다.");
	}

}
