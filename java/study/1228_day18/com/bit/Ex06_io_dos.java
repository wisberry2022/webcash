package com.bit;

import java.io.*;

public class Ex06_io_dos {

	public static void main(String[] args) {
		File f = new File("lec06.txt");
		OutputStream os = null;
		DataOutputStream dos = null;
		
		try {
			if(!f.exists()) f.createNewFile();
			os = new FileOutputStream(f);
			dos = new DataOutputStream(os);
			
			dos.write(65);
			dos.writeInt(1234);
			dos.writeDouble(3.14);
			dos.writeChar('가');
			dos.writeBoolean(true);
			dos.writeUTF("한글 문자열 입력 될까");
			dos.writeUTF("\n");
			
			if(dos != null) dos.close();
			if(os != null) os.close();
			System.out.println("끝");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
