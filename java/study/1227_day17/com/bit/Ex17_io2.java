package com.bit;

import java.io.*;

public class Ex17_io2 {

	public static void main(String[] args) {
		File f = new File("Lec16.bin");
		InputStream is;
		if(f.exists()) {
			try {
				is = new FileInputStream(f);
				// 메모장이라는 프로그램은 바이너리로 표현된 것을 문자열로 보여주기 때문에 숫자를 전달해도 메모장으로 open하면 문자열이 출력된다.
				// OutputStream 때 byte로 입력되었다하더라도 읽어들일 때는 int로 받는다. 이 때문에 읽어들이는 표현범위는 127까지가 아니라 255까지로 늘어난다.
				int su = -1;
				while(true) {
					su = is.read();
					if(su == -1) break;
					System.out.println(su);	
				}
				is.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
