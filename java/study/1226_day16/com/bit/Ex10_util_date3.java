package com.bit;

import java.util.*;

public class Ex10_util_date3 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		int before = cal.get(Calendar.DAY_OF_YEAR);
		
		// 시간 임의 설정하기
		cal.set(2023, 12-1, 6,0,0);
		System.out.println(
				cal.get(Calendar.YEAR) + "년" + (cal.get(Calendar.MONTH)+1) + "월" + cal.get(Calendar.DATE) + "일" + cal.get(Calendar.HOUR) + "시"
		);
		int after = cal.get(Calendar.DAY_OF_YEAR);
		System.out.println(before - after+1);
		
		Calendar cal2 = Calendar.getInstance();
		System.out.println(cal2.before(cal));
		System.out.println(cal2.after(cal));
		System.out.println(cal.compareTo(cal2));
	}

}
