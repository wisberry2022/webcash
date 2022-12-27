package com.priv;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

class DateCheck {
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf;
	
	public DateCheck(String pattern) {
		sdf = new SimpleDateFormat(pattern);
	}
	
	public String yesterday() {
		Calendar copy = (Calendar)(cal).clone();
		copy.add(Calendar.DATE, -1);
		return sdf.format(copy.getTime());
	}
	
	public String today() {
		return sdf.format(cal.getTime());
	}
	
	public String tomorrow() {		
		Calendar copy = (Calendar)(cal).clone();
		copy.add(Calendar.DATE, 1);
		return sdf.format(copy.getTime());
	}
	
	public String modifyDay(int num, boolean includeTodays) {
		Calendar copy = (Calendar)(cal).clone();
		if(includeTodays) {
			copy.add(Calendar.DATE, num-1);
			return sdf.format(copy.getTime());
		}else {
			copy.add(Calendar.DATE, num);
			return sdf.format(copy.getTime());
		}
	}
}


public class Priv01 {

	public static void main(String[] args) {
		System.out.println("TEST");
		Scanner sc = new Scanner(System.in);
		int select;
		
		while(true) {
			System.out.print("1.시간확인        2.시간수정        0.종료 > ");
			select = sc.nextInt();
			if(select == 1) {
				DateCheck d = new DateCheck("yyyy년   MM월   dd일        E요일");
				System.out.println("어제: " + d.yesterday());
				System.out.println("오늘: " + d.today());
				System.out.println("내일: " + d.tomorrow());
			}else if(select == 2) {
				int year, month, date;
				DateCheck d = new DateCheck("yyyy년   MM월   dd일        E요일");
				System.out.print("1.일자 증가        2.일자 감소");
				
			}else if(select == 0) {
				System.out.println("이용해주셔서 감사합니다.");
				return;
			}
		}

	}

}
