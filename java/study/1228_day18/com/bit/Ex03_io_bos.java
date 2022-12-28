package com.bit;

import java.io.*;

//IO Stream의 filter class를 사용할 때는 꼭 InputStream, OuputStream 둘 다 장착할 필요는 없다.
// filter class를 close 할 때는 장착한 순의 역순으로 진행해야한다. (장착 순서) A->B->C / (해제 순서) C->B->A
public class Ex03_io_bos {

	public static void main(String[] args) {
		String msg = "ABCDEFG HIJKLMN";
		File f = new File("lec03.bin");
		OutputStream os = null;
		BufferedOutputStream bos = null;
		
		try {
			if(f.exists()) f.createNewFile();
			os = new FileOutputStream(f);
			bos = new BufferedOutputStream(os);
			for(int i = 0; i<msg.length(); i++) {
				bos.write(msg.charAt(i));	
			}
			
			// close를 해주지 않을 경우 읽은 데이터가 사라지는 경우가 있다.
			if(bos != null) bos.close();
			if(os!=null) os.close();
			System.out.println("끝!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
