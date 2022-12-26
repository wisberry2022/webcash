package com.priv;

import java.util.*;
import java.text.*;

class DateCheck {
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf;
	
	public DateCheck(String pattern) {
		sdf = new SimpleDateFormat(pattern);
	}
	
	public String today() {
		return sdf.format(cal.getTime());
	}
	
	public String yesterday() {		
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

public class Priv02 {
	public static void main(String[] args) {
		System.out.println("TEST");
		Scanner sc = new Scanner(System.in);
		int select;
		
		while(true) {
			System.out.print("1.시간확인    0.종료 > ");
			select = sc.nextInt();
			if(select == 1) {
				DateCheck d = new DateCheck("yyyy년   MM월   dd일        E요일");
				System.out.println("오늘: " + d.today());
				System.out.println("내일: " + d.yesterday());
				System.out.println("열흘 뒤: " + d.modifyDay(10, false));
				System.out.println("열흘 뒤: " + d.modifyDay(10, true));
			}else if(select == 0) {
				System.out.println("이용해주셔서 감사합니다.");
				return;
			}
		}
	}

}
