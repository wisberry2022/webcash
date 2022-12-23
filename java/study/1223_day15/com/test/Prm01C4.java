package com.test;

import java.util.*;

public class Prm01C4 {
	public static void main(String[] args) {
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
				System.out.println("리스트");
			}else if(input == 2) {
				System.out.println("보기");
			}else if(input == 3) {
				System.out.println("입력");
			}else if(input == 4) {
				System.out.println("삭제");
			}else {
				System.out.println("입력메뉴를 다시 확인하세요");
			}
		}
		
		System.out.println("이용해주셔서 감사합니다.");
	}

}
