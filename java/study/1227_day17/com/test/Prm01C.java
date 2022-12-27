package com.test;

import java.text.*;
import java.util.*;
import java.io.*;

public class Prm01C {

	public static void main(String[] args) {
		String path = ".";
		if(args.length>0) {
			path = args[0];
		}
		File file = new File(path);
		if(file.exists()) {
			String[] arr = file.list();
			for(int i = 0; i<arr.length; i++) {
				file = new File(arr[i]);
				long nalja = file.lastModified();
				Date d = new Date(nalja);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd     a HH:mm");
				String msg = sdf.format(d);
				System.out.print(msg + "\t");
				
				if(file.isDirectory()) {
					System.out.print("<DIR>" + "\t\t");	
				}else {
					System.out.print("\t" + file.length() + "\t");	
				}
				System.out.println(file.getName());
			}
		}

	}

}
