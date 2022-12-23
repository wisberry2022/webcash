package com.test;

import java.util.*;
import java.util.Map.*;

public class Prm01C3 {
	public static void main(String[] args) {
		Map<Integer, Map<String, Integer>> data;
		data = new HashMap<>();
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
				System.out.println("----------------------------------------");
				System.out.println("학번\t국어\t영어\t수학");
				System.out.println("----------------------------------------");
				Set<Entry<Integer, Map<String, Integer>>> entrys = data.entrySet();
				Iterator<Entry<Integer, Map<String, Integer>>> ite;
				ite = entrys.iterator();
				while(ite.hasNext()) {
					Entry<Integer, Map<String, Integer>> entry;
					entry = ite.next();
					System.out.print(entry.getKey() + "\t");
					Map<String, Integer> stu = entry.getValue();
					System.out.println(stu.get("kor") + "\t" + stu.get("eng") + "\t" + stu.get("math"));
				}
				System.out.println("----------------------------------------");
			}else if(input == 2) {
				System.out.println("학번> ");
				input = sc.nextInt();
				Map<String, Integer> stu = data.get(input);
				
				System.out.println(stu.get("kor") + "\n" + stu.get("eng") + "\n" + stu.get("math"));
				
			}else if(input == 3) {
				System.out.print("학번> ");
				int num = sc.nextInt();
				Map<String, Integer> stu = new HashMap<>();
				stu = new HashMap<>();
				System.out.print("국어> ");
				stu.put("kor", sc.nextInt());
				System.out.print("영어> ");
				stu.put("eng", sc.nextInt());
				System.out.print("수학> ");
				stu.put("math", sc.nextInt());
				
				data.put(num, stu);
			}else if(input == 4) {
				System.out.print("학번> ");
				input = sc.nextInt();
				data.remove(input);
			}else {
				System.out.println("입력메뉴를 다시 확인하세요");
			}
		}
		
		System.out.println("이용해주셔서 감사합니다.");
	}

}
