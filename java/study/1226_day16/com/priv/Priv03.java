package com.priv;

import java.util.*;

public class Priv03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner("23\nlmcd");
		
		System.out.println(sc.nextInt());
		System.out.println(sc.nextLine());
		System.out.println(sc.nextLine());
		
		int num;
		String exam;
		Scanner sc2 = new Scanner(System.in);
		System.out.print("숫자 입력> ");
		num = sc2.nextInt();
		
		exam = sc2.nextLine();
		System.out.println("--------------------------------");
		System.out.println("exam: " + exam);
		System.out.print("문자 입력> ");
		exam = sc2.nextLine();
		
		System.out.println("--------------------------------");
		System.out.println(num + " " + exam);		
	}

}
