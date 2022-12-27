package com.bit;

import java.io.*;

public class Ex16_io1 {

	public static void main(String[] args) {
		String msg = "한";
		byte[] arr = msg.getBytes();
		File f = new File("Lec16.bin");
		// 단방향 채널(일방적으로 흐르는 시스템)
		// User -> File(OutputStream) / File -> User(InputStream) -> Stream의 개념은 주체가 누구냐에 따라 상대적이다.(주체를 '나'라고 생각한다)
		OutputStream os;
		try {
			if(!f.exists()) f.createNewFile();
			// 1Byte 체계의 ByteStream을 사용한다. 
			// 즉, 65를 썼어도 1Byte로 표현한 65를 작성한 꼴이 된다.
			os = new FileOutputStream(f);
			os.write('a');
			os.write('b');
			os.write('c');
			os.write('d');
			os.close();
			System.out.println("작성완료");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
