package com.bit;

import java.text.*;
import java.util.Date;

public class Ex14_simpleDateFormat {

	public static void main(String[] args) {
		Date d = new Date(2022-1900, 12-1, 6);
		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("yy-MM-d H:M:S");
//		sdf.applyLocalizedPattern();
		String msg = sdf.format(d);
		System.out.println(msg);
	}

}
