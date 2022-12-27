package com.bit;

import java.io.*;

public class Ex13_file4 {

	public static void main(String[] args) {
		File f = new File("test02");
		

		
		if(f.exists()) {
			boolean boo = f.delete();
			
			if(boo) System.out.println("삭제했습니다");
			else {
				System.out.println("하위도 모두 지우시겠습니까? Y");
				// 디렉토리에 위치한 파일/디렉토리들을 모두 제거
				File[] arr = f.listFiles();
				for(int i = 0; i<arr.length; i++) {
					arr[i].delete();
				}
				f.delete();
				System.out.println("삭제완료");
			}
		}else {
			System.out.println("없습니다");
		}
	}

}

//if(f.exists()) {
//System.out.println("존재합니다!");
//}else {
//boolean boo = f.mkdir();
//if(boo) System.out.println("파일 생성했습니다!");
//}