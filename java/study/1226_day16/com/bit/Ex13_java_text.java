package com.bit;

import java.text.DateFormat;
import java.util.*;

public class Ex13_java_text {

	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, Locale.KOREA);
		
		String msg = df.format(d);
		System.out.println(msg);	
	}
}
