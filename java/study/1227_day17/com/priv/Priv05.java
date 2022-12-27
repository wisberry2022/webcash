package com.priv;

import java.io.*;
import java.util.*;

class Student{
	static int num = 1;
	int id, ml, eng, math;
	String name;
	
	public Student(String name, int...info) {
		id = num++;
		this.name = name;
		ml = info[0];
		eng = info[1];
		math = info[2];
	}
	
}

public class Priv05 {

	public static void main(String[] args) {
		String[] strArr = new String[] {"안기성","김지석","왕인서","이민홍","유지훈","전석환","전동선","안찬영","안병혁","지상민"};
		List<Student> DataSet = new ArrayList<>();
		
		for(int i = 0; i<10; i++) {
			Random rand = new Random();
			int ml = rand.nextInt(99)+1;
			int eng = rand.nextInt(99)+1;
			int math = rand.nextInt(99)+1;
			Student stu = new Student(strArr[i], ml, eng, math);
			DataSet.add(stu);
		}
		
		File target = new File("target03.txt");
		
		try {
			if(!target.exists()) {
				target.createNewFile();
				System.out.println("파일 생성완료!");
			}
			OutputStream os = new FileOutputStream(target);
			String msg;
			
			for(int i = 0; i<DataSet.size(); i++) {
				Student stu = DataSet.get(i);
				msg = stu.name + "\t" + stu.id + "\t" + stu.ml + "\t" + stu.eng + "\t" + stu.math + "\n";
				byte[] barr = msg.getBytes();
				os.write(barr);
			}
			
			os.close();
			
			
		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
