package com.bit;

import java.io.*;

public class Ex07_StringStream04_buffer3 {

	public static void main(String[] args) {
		Writer fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter("test07.txt");
			pw = new PrintWriter(fw);
			
			pw.print(true);
			pw.print(1234);
			pw.print(3.14);
			pw.println();
			pw.println("문자열 메시지 작성");
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			// 동작 중 에러가 발생했을 시 fw, pw를 반드시 close하게 해준다. (필수!!!!!!!!!!!!)
			try {
				if(pw != null) pw.close();			
				if(fw != null) fw.close();	
			}catch(IOException e) {
				e.printStackTrace();	
			}
			
		}

		
		
	}

}
