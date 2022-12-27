package com.priv;

import java.io.*;

public class Priv06 {

	public static void main(String[] args) {
		File read = new File("target03.txt");
		
		if(read.exists()) {
			try {
				InputStream is = new FileInputStream(read);	
//				OutputStream os = System.out;
				byte[] bArr = new byte[(int)read.length()];
				int su;
				int idx = 0;
				while(true) {
					su = is.read();
					if(su == -1) break;
					bArr[idx++] = (byte)su;
//					System.out.print((char)su);
//					os.write(su);
				}
				
				String msg = new String(bArr);
				System.out.println(msg);
				
				is.close();
//				os.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}

	}

}
