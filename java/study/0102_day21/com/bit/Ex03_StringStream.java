package com.bit;

import java.io.*;

public class Ex03_StringStream {

	public static void main(String[] args) {
		File f = new File("test03.txt");
		Writer pw = null;
		try {
			if(!f.exists()) f.createNewFile();
			pw = new FileWriter(f);
			
			// 문자열 stream은 2Byte 체계에 가깝다.(실제론 2Byte는 아니지만 JAVA에서 편리하게 이용할 수 있도록 비슷하게 구현하였다.)
			// 문자열을 위한 stream이기 때문에 다른 용도로 사용한다면 문제가 발생할 수 있다(2Byte 체계이기 때문에 문자열 처리가 아니면, 2Byte로 강제로 맞춰버리기 때문에 문제가 발생한다)
			// 반드시 문자열 처리를 위해 사용하여야 한다.
			pw.write("안녕 20");
			
			
			if(pw != null) pw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
