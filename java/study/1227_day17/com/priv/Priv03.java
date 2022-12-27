package com.priv;

import java.util.*;
import java.io.*;

public class Priv03 {

	public static void main(String[] args) {
		File read = new File("readable.txt");
		File write = new File("target01.txt");
		
		try {
			if(!read.exists() || !write.exists()) {
				read.createNewFile();
				write.createNewFile();
				System.out.println("파일 생성 완료!");
			}else {
				int su;
				InputStream is = new FileInputStream(read);
				OutputStream os = new FileOutputStream(write);
				
				while(true) {
					su = is.read();
					if(su == -1) break;
					os.write(su);
				}
				
				is.close();
				os.close();
				System.out.println("카피 완료!");
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
		
		

	}

