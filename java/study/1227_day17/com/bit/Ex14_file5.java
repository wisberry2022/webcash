package com.bit;

import java.io.*;

public class Ex14_file5 {

	public static void main(String[] args) {
		File f = new File(".\\test02\\test02.txt");
		
		if(f.exists()) {
			System.out.println("존재합니다!");
		}else {
			boolean boo = f.mkdir();
			if(boo) System.out.println("파일 생성했습니다!");
		}		

		
		
	}

}

