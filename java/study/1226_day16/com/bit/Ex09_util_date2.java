package com.bit;

import java.util.*;

public class Ex09_util_date2 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		// 이번 년도로부터 며칠이 지났는지 반환
		System.out.println(cal.get(Calendar.DAY_OF_YEAR));
		// 이번 달 중 금일이 몇 일인지 반환
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.DATE));
		
		// 이번주가 이번달 중 몇주차인지 반환
		System.out.println(cal.get(Calendar.WEEK_OF_MONTH));
		// 올해로부터 몇주차인지 반환
		System.out.println(cal.get(Calendar.WEEK_OF_YEAR));
		
		System.out.println(cal.SUNDAY);
	}

}
