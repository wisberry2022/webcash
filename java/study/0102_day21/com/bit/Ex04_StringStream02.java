package com.bit;

import java.io.*;

public class Ex04_StringStream02 {

	public static void main(String[] args) {
		File f = new File("test03.txt");
		Reader fr = null;
		char[] buf = new char[8];
		try {
			fr = new FileReader(f);
			while(true) {
				int su = fr.read(buf);
				if(su == -1) break;
				String msg = new String(buf, 0, su);
				System.out.print(msg);
			}
			
		
			if(fr != null) fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
