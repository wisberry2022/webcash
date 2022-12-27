package com.bit;

import java.io.*;

public class Ex12_file3 {

	public static void main(String[] args) {
		File f = new File("Lec02.txt");
		if(f.exists()) {
			boolean boo = f.delete();
			if(boo) System.out.println("삭제완료");
		}else {
			System.out.println("파일없음");
		}

	}

}
