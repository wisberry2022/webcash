package com.bit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Set;
import java.util.TreeSet;

public class Ex12_ObjectIO_class2 {

	public static void main(String[] args) {
		InputStream is = null;
		ObjectInputStream ois = null;
		
		try {
			is = new FileInputStream("test02.bin");
			ois = new ObjectInputStream(is);
			
			Student obj = (Student)ois.readObject();
			System.out.println(obj.math);
			
			ois.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
