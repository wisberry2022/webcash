package com.bit;

import java.io.*;

public class Ex06_StringStream03_buffer2 {

	public static void main(String[] args) {
		File f = new File("test04.txt");
		
		Reader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			
//			int su = -1;
//			while((su = br.read()) != -1) {
//				System.out.print((char)su);
//			}
			// readLine -> 개행(\r\n, \n)을 기준으로 읽게된다.
			// 더 이상 읽을 것이 없다면 null을 반환한다.
			String msg = null;
			
			while((msg = br.readLine()) != null) {
				System.out.println(msg);
			}

						
			if(br != null) br.close();
			if(fr != null) fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
