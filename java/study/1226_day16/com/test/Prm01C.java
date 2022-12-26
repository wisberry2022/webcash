package com.test;

import java.util.*;
import java.text.*;

public class Prm01C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date d = new Date(2022-1900, 12-1, 26);
		long before = d.getTime();
		System.out.println(before);
		before += 1000L * 60L * 60L * 24L * 100L;
		
		Date d2 = new Date(before);
		System.out.println(d);
		System.out.println(d2);
		
		Calendar cal = new GregorianCalendar(2022, 12-1, 26);
		cal.add(Calendar.DATE, 100);
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH));
		System.out.println(cal.get(Calendar.DATE));
	}

}
