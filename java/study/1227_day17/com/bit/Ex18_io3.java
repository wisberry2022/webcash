package com.bit;

import java.io.*;

public class Ex18_io3 {

	public static void main(String[] args) {
		File target = new File("logo.png");
		File result = new File("copy.png");
		byte[] buf = new byte[10];
		
		InputStream is;
		OutputStream os;
		
		try {
			if(!result.exists()) {
				result.createNewFile();
			}
			is = new FileInputStream(target);
			os = new FileOutputStream(result);
			while(true) {
				int su = is.read(buf);
				if(su == -1) break;
				os.write(buf);
			}
			os.close();
			is.close();
			
			System.out.println("복사 완료!");
		}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}		
}

