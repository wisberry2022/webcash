package com.bit;

import java.io.*;

public class Ex07_io_dis {

	public static void main(String[] args) {
		File f = new File("lec06.bin");
		
		InputStream is = null;
		DataInputStream dis = null;
		
		try {
			// 반드시 dos.write() 한 순서대로 읽어야한다. 그렇지 않을 경우 에러 발생
			if(f.exists()) {
				is = new FileInputStream(f);
				dis = new DataInputStream(is);
				String su1 = dis.readUTF();
				String su2 = dis.readUTF();
				String su3 = dis.readUTF();
				String su4 = dis.readUTF();
				String su5 = dis.readUTF();
//				String su6 = dis.readUTF();
				System.out.print(su1 + "\t" + su2 + "\t" + su3 + "\t" + su4 + "\t" + su5 + "\t");
				
			}
			
			if(dis != null) dis.close();
			if(is != null) is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
