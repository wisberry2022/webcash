package com.bit.boot02.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TransferDateFormat {

	private static SimpleDateFormat before = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
	private static SimpleDateFormat after = new SimpleDateFormat("yyyy-MM-dd");
	private static TransferDateFormat me = new TransferDateFormat();
	
	private TransferDateFormat() {
		
	}
	
	public static TransferDateFormat getInstance() {
		return me;
	}
	
	public String stringToDate(String source) {
		String result = null;
		try {
			Date d = before.parse(source);
			result = after.format(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return result;	
	}
	
}
