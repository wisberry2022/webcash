package com.bit;

import java.io.*;

public class Ex01_io {

	public static void main(String[] args) {
		String msg = "abcdefg hijklmn";
		File f = new File("Lec01.bin");
		OutputStream os;
		try {
			if(!f.exists()) f.createNewFile();
			os = new FileOutputStream(f);
			
			for(int i = 0; i<msg.length(); i++) {
				os.write(msg.charAt(i));
			}
			
			os.close();
//			System.out.println()
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
