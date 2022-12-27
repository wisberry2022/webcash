package com.priv;

import java.io.*;

class Stud {
	int ml, math, lang;
	
}

public class Priv04 {

	public static void main(String[] args) {
		
		String msg = "안녕하세요!";
		byte[] bArr = msg.getBytes();
		File write = new File("target02.txt");
		
		try { 
			if(!write.exists()) {
				String bar = "학번\t국어\t수학\t영어";
				
				write.createNewFile();
				System.out.println("파일 생성완료!");
				OutputStream nos = new FileOutputStream(write);
				
				nos.write(bar.getBytes());
				nos.close();
			}
			InputStream is = new FileInputStream(write);
			
			int su = -1;
			byte[] iarr = new byte[(int)write.length()];
			int idx = 0;
			while(true) {
				su = is.read();
				if(su == -1) break;
				iarr[idx++] = (byte)su;
			}
			
			System.out.println(new String(iarr));
			
			is.close();

		}catch(IOException e) {
			e.printStackTrace();
		}
		

	}

}
