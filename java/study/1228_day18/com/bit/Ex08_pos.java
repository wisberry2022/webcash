package com.bit;

import java.io.*;

public class Ex08_pos {

	// PrintStream -> OutputStream만 존재한다
	public static void main(String[] args) {
		File f = new File("lec06.bin");
		
		OutputStream os = null;
		PrintStream ps = null;
		
		try {
			if(!f.exists()) f.createNewFile();
			os = new FileOutputStream(f);
			ps = new PrintStream(os);
			
			ps.write(12);
			// 자동으로 문자열 처리를 하여 파일에 저장해준다
			ps.println(4321);
			ps.println(4.14);
			ps.println('한');
			ps.println(false);
//			ps.println("abcdefg");
			
			if(ps != null) ps.close();
			if(os != null) os.close();
		} catch (IOException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
