package com.bit;

import java.io.*;

public class Ex05_StringStream02_buffer {

	public static void main(String[] args) {
		File f = new File("test04.txt");
		Writer fw = null;
		BufferedWriter bw = null;
		
		try {
			// 별도로 createNewFile을 통해 파일을 생성하지 않았지만 파일이 저절로 생성된다.
			fw=new FileWriter(f);
			bw=new BufferedWriter(fw);
			
			bw.write("문자열을 버퍼를 이용해 작성할 예정입니다!");
			// buffer에서 담고있는 데이터를 비워준다.
			// flush 사용의 빈도를 너무 높게 지정하면 buffer의 의미가 사라진다. 적절하게 사용하여야한다.(통신 io에서 필요하다)
			bw.flush();
//			bw.write("\r\n");
			// 자동으로 개행문자 삽입
			bw.newLine();
			bw.write("또 한 줄 더 야무지게 작성하겠습니다");
			
			if(bw != null) bw.close();
			if(fw != null) fw.close();
			System.out.println("작성완료");
			
		} catch (IOException e) {
			// 
			e.printStackTrace();
		}

	}

}
