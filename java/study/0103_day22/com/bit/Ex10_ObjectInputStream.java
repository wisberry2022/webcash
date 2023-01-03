package com.bit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

class Student2 {
	int id;
	int ml, eng, math;
	
	public Student2(int id, int ml, int eng, int math) {
		this.id = id;
		this.ml = ml;
		this.eng = eng;
		this.math = math;
	}
}

public class Ex10_ObjectInputStream {

	public static void main(String[] args) {
		InputStream is = null;
		ObjectInputStream ois = null;
		
		try {
			is = new FileInputStream("data01.bin");
			ois = new ObjectInputStream(is);
			
			int su1 = ois.readInt();
			double su2 = ois.readDouble();
			boolean boo = ois.readBoolean();
			String msg = ois.readUTF();
			
			int[] arr1 = (int[]) ois.readObject();
			Vector arr2 = (Vector)ois.readObject();
			Map data = (HashMap) ois.readObject();
			
			for(int i = 1; i<data.size(); i++) {
				int[] data2 = (int[])data.get(i);
				for(int j = 0; j<data2.length; j++) {
					System.out.print(data2[j] + " ");
				}
				
			}
			
			
			System.out.println(su1);
			System.out.println(su2);
			System.out.println(boo);
			System.out.println(msg);
			System.out.println(Arrays.toString(arr1));
			System.out.println(Arrays.toString(arr2.toArray()));
			System.out.println(data);
//			Student2 std = (Student2) ois.readObject();
//			System.out.println(std);
			
			if(ois != null) ois.close();
			if(is!=null) is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
