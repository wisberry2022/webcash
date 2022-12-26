package com.bit;

import java.util.*;

public class Ex08_util_date {

	public static void main(String[] args) throws InterruptedException {
		//날짜
		Calendar cal;
		
		
		cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR) + "년");
		
		System.out.println(cal.get(Calendar.MONTH)+1 + "월");
		System.out.println(cal.get(Calendar.DATE) + "일");
		System.out.println(cal.get(Calendar.DAY_OF_MONTH) + "일");
		System.out.println(cal.get(Calendar.HOUR) + "시");
		System.out.println(cal.get(Calendar.HOUR_OF_DAY) + "시");
		System.out.println(cal.get(Calendar.AM_PM)*12+cal.get(Calendar.HOUR) + "시2");
		System.out.println(cal.get(Calendar.MINUTE) + "분");
		System.out.println(cal.get(Calendar.SECOND) + "초");
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		
		switch(cal.get(Calendar.DAY_OF_WEEK)) {
			case Calendar.SUNDAY:
				System.out.println("일요일"); break;
			case Calendar.MONDAY:
				System.out.println("월요일"); break;
			case Calendar.TUESDAY:
				System.out.println("화요일"); break;
			case Calendar.WEDNESDAY:
				System.out.println("수요일"); break;
			case Calendar.THURSDAY:
				System.out.println("목요일"); break;
			case Calendar.FRIDAY:
				System.out.println("금요일"); break;
			case Calendar.SATURDAY:
				System.out.println("토요일"); break;
		}
		
		switch(cal.get(Calendar.AM_PM)) {
			case Calendar.AM:
				System.out.println("AM"); break;
			case Calendar.PM:
				System.out.println("PM"); break;
		}
	}
}
