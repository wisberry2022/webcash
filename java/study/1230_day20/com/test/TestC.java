package com.test;

import java.util.*;
import java.io.*;

public class TestC {

	public static void main(String[] args) {
		File f = new File(".data.bin");
		System.out.println("학생성적관리프로그램(ver 0.5.0)");
		Scanner sc = new Scanner(System.in);
		
		int input = -1;
		while(true) {	
			System.out.print("1.리스트  2.상세보기  3.입력   4.수정   5.삭제   0.종료");
			input = sc.nextInt();	
			if(input == 0) {
				System.out.println("이용해주셔서 감사합니다!");
				break;
			}
			if(input == 1) {
				System.out.println("--------------------------------------------");
				System.out.println("학번\t국어\t영어\t수학");
				System.out.println("--------------------------------------------");
				if(f.exists()) {
					InputStream is = null;
					try {
						is = new FileInputStream(f);
						int cnt = 0;
						while(true) {
							cnt++;
							int su = is.read();
							if(su == -1) break;
							System.out.print(su +"\t");
							if(cnt%4 == 0) {
								System.out.println();
							}
						}
						if(is != null) is.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}	
				}else {
					System.out.println("\n존재하지 않습니다");
				}
				System.out.println("--------------------------------------------");
			}
			if(input == 2) {
				System.out.print("학번> ");
				int num = sc.nextInt();
				InputStream is = null;
				try {
					is = new FileInputStream(f);
					while(true) {
						int su1 = is.read();
						if (su1 == -1) break;
						int su2 = is.read();
						int su3 = is.read();
						int su4 = is.read();
						if(num == su1) {
							System.out.println("국어>"+ su2);
							System.out.println("영어>"+ su3);
							System.out.println("수학>"+ su4);
						}
					}
					if(is != null) is.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}
			if(input == 3) {
				System.out.print("학번> ");
				int num = sc.nextInt();
				System.out.print("국어> ");
				int kor = sc.nextInt();
				System.out.print("영어> ");
				int eng = sc.nextInt();
				System.out.print("수학> ");
				int math = sc.nextInt();
				OutputStream os = null;
				InputStream is = null;
				
				try {
					if(!f.exists()) {
						f.createNewFile();
						os = new FileOutputStream(f);
					}else {
						File temp = new File("temp");
						os = new FileOutputStream(temp);
						is = new FileInputStream(f);
						while(true) {
							int su = is.read();
							if(su == -1) break;
							os.write(su);
						}
						if(os != null) os.close();
						if(is != null) is.close();
						is = new FileInputStream(temp);
						os = new FileOutputStream(f);
						while(true) {
							int su = is.read();
							if(su == -1) break;
							os.write(su);
						}
						if(is!=null) is.close();
						temp.delete();
					}
					os.write(num);
					os.write(kor);
					os.write(eng);
					os.write(math);
					os.close();	
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(input == 4) {}
			if(input == 5) {}
		}

	}

}
