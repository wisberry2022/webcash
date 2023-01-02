package com.bit;

import java.io.*;

public class Ex10_OutputStreamWriter {

	public static void main(String[] args) {
		OutputStream os = null;
		OutputStreamWriter osw = null;
		
		try {
			os = new FileOutputStream("test05.txt");
			osw = new OutputStreamWriter(os);
			
			osw.write("문자열을 작성합니다!");
			
			System.out.println("작성완료!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(osw != null) osw.close();
				if(os != null) os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
