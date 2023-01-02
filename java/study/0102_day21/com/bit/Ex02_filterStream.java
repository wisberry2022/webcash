package com.bit;

import java.io.*;

public class Ex02_filterStream {

	public static void main(String[] args) {
		File f = new File("test01.txt");
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		ByteArrayInputStream bais = null;
		try {
			is = new FileInputStream(f);
			// 크기가 서로 다른 Byte를 받아야 할 때, ByteArrayOutputStream은 byte들을 담을 임시 공간과도 같다.
			// 파일에 쓰고, 필요할 때 다시 읽지 않고, 자료구조를 사용하여 byte를 담는 것처럼 활용할 수 있다.(읽어들이는 대상이 파일이 아닌 메모리가 되는 것이다) -> 값의 누적을 용이하게 한다.
			baos = new ByteArrayOutputStream();
			// ByteArrayInputStream은 사용자 buffer를 요구한다.
//			bais = new ByteArrayInputStream();
			
			int su =  -1;
			while((su=is.read()) != -1) {
				baos.write(su);
			}
			
			byte[] arr = baos.toByteArray();
			System.out.println("string 변환 " + new String(arr));
			bais = new ByteArrayInputStream(arr);
			su = -1;
			while((su = bais.read())!=-1) {
				System.out.println(su);
			}
			System.out.println(new String(arr));
			
			if(bais != null) bais.close();
			if(baos != null) baos.close();
			if(is != null) is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
