package com.test;

import java.util.*;
import java.text.*;

public class Prm01 {

	public static void main(String[] args) {
		// 100일 계산기
		// >년
		// >월
		// >일
		// 0000-01-01에서 100일 뒤는 0000-00-00입니다.
		Scanner sc = new Scanner(System.in);
		int year, month, date;
		String before, after;
		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println("100일 계산기");
		System.out.print(">년 ");
		year = sc.nextInt();
		System.out.print(">월 ");
		month = sc.nextInt();
		System.out.print(">일 ");
		date = sc.nextInt();
		
		Calendar d = new GregorianCalendar();
		d.set(year, month-1, date);
		before = sdf.format(d.getTime());
		
		d.add(Calendar.DATE, 99);
		after = sdf.format(d.getTime());
		
		System.out.println(before + "에서 100일 뒤는 " + after + "입니다");
	}

}
