package com.bit;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

class Student implements Serializable {
	int id = 1;
	// ObjectOutputStream 시 값 전달을 막는다(읽어들일 땐 0이 나온다)
	transient int math = 2345;
	
	// 메소드는 Serializable의 대상이 아니다.
	public void func() {
		System.out.println("func run - " + id);
	}
}

public class Ex11_ObjectIO_class {

	public static void main(String[] args) {
		OutputStream os = null;
		ObjectOutputStream oos = null;
		
		try {
			os = new FileOutputStream("test02.bin");
			oos = new ObjectOutputStream(os);
			
			Student lec = new Student();
			
			oos.writeObject(lec);
			
			if(os != null) os.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
