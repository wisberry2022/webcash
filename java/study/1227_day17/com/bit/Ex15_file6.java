package com.bit;

import java.io.*;

public class Ex15_file6 {

	public static void main(String[] args) {
		File file = new File("Lec01.txt");
		try {
			//prefix + random숫자 + suffix(주로 확장자)의 파일이 생성된다
			File file2 = file.createTempFile("abcdefg", ".txt");
			System.out.println(file2.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
