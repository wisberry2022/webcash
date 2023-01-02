package com.bit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Ex11_InputStreamWriter {

	public static void main(String[] args) {
		InputStream is = null;
		Reader isr = null;
		
		try {
			is = new FileInputStream("test05.txt");
			isr = new InputStreamReader(is);
			
			int su = -1;
			
			while((su = isr.read()) != -1) {
				System.out.print((char)su);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(isr != null) isr.close();
				if(is != null) is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
