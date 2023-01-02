package com.bit;

import java.io.*;

public class Ex09_autoClose {

	public static void main(String[] args) {
		// autoClose -> stream의 close를 자동으로 해준다. (jdk 1.8이상에서만 동작)
		// try( stream 선언 및 초기화 ){}
		try(
			// closeable 인터페이스를 상속받는 객체만 try() 구문안에 들어올 수 있다.
			// 그렇지 않은 코드들을 해당 블럭 안에 들어올 수 없다.
			// Stream의 선언이 외부에서 이루어지면 안된다.
			Reader fr = new FileReader("test07.txt");
			BufferedReader br = new BufferedReader(fr);
		){
			String msg = null;
			while((msg = br.readLine())!=null) {
				System.out.println(msg);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
