package com.bit;

import java.io.*;
import java.util.*;

public class Ex10_file {

	public static void main(String[] args) {
		
		// 생략된 상대경로(현재 경로는 생략이 가능하다)
//		File file = new File("Lec01.txt");
		// 명시적 상대경로
//		File file = new File(".\\Lec01.txt");
//		File file = new File("E:\\java\\gov\\day17");
//		File file = new File("E:\\java\\gov\\day17");
		File file = new File("E:\\java\\gov\\day17\\src\\com\\bit");
		
		System.out.println("유무? " + file.exists());
		if(file.exists()) {
			System.out.println("dir? " + file.isDirectory());
			System.out.println("file? " + file.isFile());
			System.out.println("path: " + file.getPath());
			// 전체 path에서 parent directory 경로까지만 출력
			System.out.println("location: " + file.getParent());
			// 이름만 출력
			System.out.println("name: " + file.getName());
			System.out.println("absolute path 01: " + file.getAbsolutePath());
			// 진짜 절대경로
			try {
				// file을 상대경로로 받더라도 제대로된 절대경로를 반환하는 메소드(.getCanonicalPath())
				System.out.println("absolute path 02: " + file.getCanonicalPath());	
			}catch(IOException e) {
				System.out.println("error!");
			}
			
			// 읽기 권한 확인
			System.out.println("r:" + file.canRead());
			// 쓰기 권한 확인
			System.out.println("w:" + file.canWrite());
			// 실행 권한 확인
			System.out.println("x:" + file.canExecute());
			System.out.println("size: " + file.length()+"byte");
			// lastModified => 최근 수정 날짜(long type으로 반환)
			System.out.println(new Date(file.lastModified()));
			String[] arr = file.list();
			for(int i = 0; i<arr.length; i++) {
				System.out.println(arr[i]);
			}
		}

	}

}
