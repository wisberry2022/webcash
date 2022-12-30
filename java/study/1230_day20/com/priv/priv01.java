package com.priv;

import java.io.*;

public class priv01 {

	public static void main(String[] args) {
		File f = new File("test01.txt");
		
//		OutputStream os = null;
		InputStream is = null;
		
		try {
			if(!f.exists()) f.createNewFile();
			is = System.in;
			byte[] bArr = new byte[10];
			int su;
			int idx = 1;
			while(idx < 5) {
				su = is.read(bArr);
				idx++;
			}
			System.out.println(new String(bArr));
			if(is != null) is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
