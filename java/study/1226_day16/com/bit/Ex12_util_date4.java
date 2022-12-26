package com.bit;

import java.util.*;

public class Ex12_util_date4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date dat;
//		dat = new Date(2002-1900, 5-1, 1);
		dat = new Date();
		System.out.println(dat);
		
//		dat.setYear(2002-1900);
//		dat.setMonth(5-1);
		
		// 1900년이 기준이다.
		System.out.println(dat.getTime());
		System.out.println(dat.getYear()+1900);
		System.out.println(dat.getMonth()+1);
		System.out.println(dat.getDate());
		System.out.println(dat.getHours());
		System.out.println(dat.getMinutes());
		System.out.println(dat.getSeconds());
	}

}
