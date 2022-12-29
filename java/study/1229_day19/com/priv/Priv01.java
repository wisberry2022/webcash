package com.priv;

import java.util.*;
import java.io.*;

class Student implements Comparable {
	private String id;
	private int ml;
	private int eng;
	private int math;
	
	public Student(String id, int ml, int eng, int math) {
		this.id = id;
		this.ml = ml;
		this.eng = eng;
		this.math = math;
	}
	
	public String getId() {
		return id;
	}
	
	public int getMl() {
		return ml;
	}
	
	public int getEng() {
		return eng;
	}
	
	public int getMath() {
		return math;
	}
	
	public void setMl(int score) {
		this.ml = score;
	}
	public void setEng(int score) {
		this.eng = score;
	}
	public void setMath(int score) {
		this.math = score;
	}
	
	public int getSum() {
		return ml+eng+math;
	}
	
	public double getAvg() {
		return (int)(this.getSum()*100 / 3.0) * 0.01;
	}
	
	public String getGrade() {
		int sum = this.getSum();
		if(3*90 <= sum && sum <= 3*100) return "A";
		else if(3*80 <= sum && sum < 3*90) return "B";
		else if(3*70 <= sum && sum < 3*80) return "C";
		else if(3*60 <= sum && sum < 3*70) return "D";
		else return "F";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return Integer.parseInt(this.id) - Integer.parseInt(((Student)(o)).id);
	}	
}

public class Priv01 {

	static Map<String, Student> DataSet = new TreeMap<>();
	
	public static void main(String[] args) {
		System.out.println("�л������������α׷� ver0.3.0");
		String select;
		File DB = new File("studentDB.txt");
		
		InputStream is = null;
		OutputStream os = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			if(!DB.exists()) DB.createNewFile();
			is = new FileInputStream(DB);
			bis = new BufferedInputStream(is);
			
			byte[] readArr = new byte[(int)DB.length()/5];
			
			int su;
			String msg = "";
			while(true) {
				su = bis.read(readArr);
				if(su == -1) break;
				byte[] temp = new byte[su];
				for(int i = 0; i<su; i++) {
					temp[i] = readArr[i];
				}
				msg += new String(temp);
			}
			
			String[] rawDatas = msg.split("\n");
			int ml, eng, math;
			for(int i = 1; i<rawDatas.length; i++) {
				String[] rawData = rawDatas[i].split("\t");
				ml = Integer.parseInt(rawData[1]);
				eng = Integer.parseInt(rawData[2]);
				math = Integer.parseInt(rawData[3]);
				DataSet.put(rawData[0], new Student(rawData[0], ml, eng, math));
			}
			
			if(bis != null) bis.close();
			if(is != null) is.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		while(true) {
			java.util.Scanner sc = new java.util.Scanner(System.in);
			System.out.print("1.����Ʈ    2.�Է�    3.����    4.����    5.�󼼺���    0.����    >");
			select = sc.nextLine();
			if(select.equals("0")) {
				try {
					if(!DB.exists()) DB.createNewFile();
					is = new FileInputStream(DB);
					os = new FileOutputStream(DB);
					bos = new BufferedOutputStream(os);
					
					String msg = "�й�\t����\t����\t����\n";
					String temp;
					
					Collection<Student> mSet = DataSet.values();
					Iterator<Student> ite = mSet.iterator();
					while(ite.hasNext()) {
						Student info = ite.next();
						temp = info.getId() + "\t" + info.getMl() + "\t" + info.getEng() + "\t" + info.getMath() + "\n";
						msg += temp;
					}
					
					byte[] bArr = msg.getBytes();
					os.write(bArr);
					
					if(bos != null) bos.close();
					if(os != null) os.close();
					if(is != null) is.close();	
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
							
				System.out.println("�л������������α׷� ����");
				return;
			}else if(select.equals("1")) {
				Set data = DataSet.keySet();
				System.out.println("----------------------------����Ʈ----------------------------");
				System.out.println("�й�\t����\t����\t����");
				
				Collection<Student> list = DataSet.values();
				Iterator<Student> ite = list.iterator();
				while(ite.hasNext()) {
					Student stu = ite.next();
					System.out.println(stu.getId() + "\t" + stu.getMl() + "\t" + stu.getEng() + "\t" + stu.getMath());
				}
				System.out.println("------------------------------------------------------------");
			}else if(select.equals("2")) {
				String id;
				int ml, eng, math;
				while(true) {	
					System.out.print("�й�> ");
					id = sc.nextLine();
					if(DataSet.get(id) == null) {
						break;
					}
					System.out.println("�̹� �����ϴ� �й��Դϴ�! �ٽ� �Է����ּ���!");
				}
				System.out.print("����> ");
				ml = sc.nextInt();
				System.out.print("����> ");
				eng = sc.nextInt();
				System.out.print("����> ");
				math = sc.nextInt();
				DataSet.put(id, new Student(id, ml, eng, math));
				System.out.println();
			}else if(select.equals("3")) {
				String id;
				int ml, eng, math;
				System.out.print("�й� > ");
				id = sc.nextLine();
				if(DataSet.containsKey(id)) {
					Student stu = (Student)DataSet.get(id);
					System.out.print("����> ");
					ml = sc.nextInt();
					stu.setMl(ml);
					System.out.print("����> ");
					eng = sc.nextInt();
					stu.setEng(eng);
					System.out.print("����> ");
					math = sc.nextInt();
					stu.setMath(math);
					DataSet.replace(id, stu);
					System.out.println("�����Ϸ�!");
				}else {
					System.out.println("�������� �ʴ� �й��Դϴ�!");
				}					
			}else if(select.equals("4")) {
				String id;
				System.out.print("�й� >");
				id = sc.nextLine();
				if(DataSet.get(id) != null) {
					DataSet.remove(id);
					System.out.println("�����Ϸ�!");
				}else {
					System.out.println("�������� �ʴ� �й��Դϴ�!");
				}
			}else if(select.equals("5")) {
				String id;
				int sum = 0;
				double tAvg = 0.0;
				Set<String> total = DataSet.keySet();
				Iterator<String> ite = total.iterator();
				while(ite.hasNext()) {
					String tid = ite.next();
					Student stu = DataSet.get(tid); 
					sum += stu.getAvg();
				}
				tAvg = (int)(sum*100 / (float)(DataSet.size())) * 0.01;
				System.out.print("�й�> ");
				id = sc.nextLine();
				System.out.println("-------------------------------------------");
				if(DataSet.get(id) != null) {
					Student stu = DataSet.get(id);
					System.out.println("�����հ�: "+ stu.getSum());
					System.out.println("�������(�л����/��ü���): "+ stu.getAvg() + " / " + tAvg);
					System.out.println("��      ��: "+ stu.getGrade());
					
				}else {
					System.out.println("�������� �ʴ� �й��Դϴ�!");
				}
				System.out.println("-------------------------------------------");		
			}
		}
	}
}
