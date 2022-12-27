package com.test;

import java.io.File;
import java.util.*;
import java.text.*;

public class Prm01 {

	public static void main(String[] args) {
		File file;
		try {
			File before = new File(args[0]);
			String absolutePath = "";
			try {
				absolutePath = before.getCanonicalPath();	
			}catch(Exception e) {
				e.fillInStackTrace();
			}
			
			file = new File(absolutePath);
		}catch(ArrayIndexOutOfBoundsException e) {
			file = new File("./");	
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd     a HH:mm");
				
		if(file.isDirectory()) {
//			System.out.println(file.getName());
			String createDate;
			String isDir;
			String size;
			String filename;
			String[] list = file.list();
			for(int i = 0; i<list.length; i++) {
				filename = list[i];
				File subFile = new File(filename);	
				createDate = sdf.format(new Date(subFile.lastModified()));
				if(subFile.isDirectory()) {
					isDir = "<DIR>";
					size = "";
				}else {
					isDir = "";
					size = new Integer((int)(subFile.length())).toString();
				}
				System.out.println(createDate + "\t" + isDir + "\t" + size + "\t" + filename + "\t" );
			}
		}
		
	}

}
