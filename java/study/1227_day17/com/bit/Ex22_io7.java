package com.bit;

import java.io.*;

public class Ex22_io7 {

	public static void main(String[] args) {
		File f = new File("Lec21.txt");
		// 실제 데이터의 용량보다 더 많은 단위를 읽어들여 복사된 데이터는 필요 이상으로 size가 커지게 된다. -> 피해야 하는 상황
		byte[] arr = new byte[10];
		InputStream is;		
		try {
			is = new FileInputStream(f);
			while(true) {
				int su = is.read(arr);
				if(su == -1) break;
				System.out.println(new String(arr));		
			}
			is.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
