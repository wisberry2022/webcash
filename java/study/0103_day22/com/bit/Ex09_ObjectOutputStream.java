package com.bit;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

class Student1 {
	int id;
	int ml, eng, math;
	
	public Student1(int id, int ml, int eng, int math) {
		this.id = id;
		this.ml = ml;
		this.eng = eng;
		this.math = math;
	}
}

public class Ex09_ObjectOutputStream {

	public static void main(String[] args) {
		
		// ObjectStream
		OutputStream os = null;
		ObjectOutputStream oos = null;
		try {
			os = new FileOutputStream("data01.bin");
			oos = new ObjectOutputStream(os);
			
			oos.writeInt(1234);
			oos.writeDouble(3.14);
			oos.writeBoolean(true);
			oos.writeUTF("문자열");
			
			int[] arr1 = {1,3,5,7,9};
			oos.writeObject(arr1);
			
			Vector arr2 = new Vector();
			arr2.add(1234);
			arr2.add(3.14);
			arr2.add(true);
			arr2.add('A');
			arr2.add("");
			oos.writeObject(arr2);
			
			Map data = new HashMap();
			data.put(1, new int[] {80,90,100});
			data.put(2, new int[] {80,90,100});
			data.put(3, new int[] {80,90,100});
			data.put(4, new int[] {80,90,100});
			
			oos.writeObject(data);
			if(oos != null) oos.close();
			if(os != null) os.close();
			System.out.println("작성완료!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
