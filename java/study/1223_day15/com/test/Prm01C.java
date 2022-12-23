package com.test;

import java.util.*;

public class Prm01C {
	public static void main(String[] args) {
		List<int[]> data = new ArrayList<int[]>();
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
				System.out.println("----------------------------------------------");
				System.out.println("학번\t국어\t영어\t수학");
				System.out.println("----------------------------------------------");
				for(int i = 0; i<data.size(); i++) {
					int[] stu = data.get(i);
					System.out.print(stu[0] + "\t");
					System.out.print(stu[1] + "\t");
					System.out.print(stu[2] + "\t");
					System.out.println(stu[3]);
				}
				System.out.println("----------------------------------------------");
			}else if(input == 2) {
				System.out.print("학번>");
				input = sc.nextInt();
				System.out.println("----------------------------------------------");
				for(int i = 0; i<data.size(); i++) {
					int[] stu = data.get(i);
					if(stu[0] == input) {
						System.out.print(stu[0] + "\t");
						System.out.print(stu[1] + "\t");
						System.out.print(stu[2] + "\t");
						System.out.println(stu[3]);
						System.out.println(stu[1] + stu[2] + stu[3]);
						System.out.println((stu[1] + stu[2] + stu[3])*100/3/100.0);
						break;
					}
				}
				System.out.println("----------------------------------------------");
			}else if(input == 3) {
				int[] stu = new int[4];
				System.out.print("학번> ");
				stu[0] = sc.nextInt();
				System.out.print("국어> ");
				stu[1] = sc.nextInt();
				System.out.print("영어> ");
				stu[2] = sc.nextInt();
				System.out.print("수학> ");
				stu[3] = sc.nextInt();
				data.add(stu);
			}else if(input == 4) {
				System.out.print("학번>");
				input = sc.nextInt();
				System.out.println("----------------------------------------------");
				for(int i = 0; i<data.size(); i++) {
					int[] stu = data.get(i);
					if(stu[0] == input) {
						data.remove(i);
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
