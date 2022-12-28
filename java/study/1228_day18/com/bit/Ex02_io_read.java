package com.bit;

import java.io.*;

public class Ex02_io_read {

	public static void main(String[] args) {
		File f = new File("Lec01.bin");
		File copy = new File("copy.bin");
		byte[] buf = new byte[2];
		InputStream is = null;
		OutputStream os = null;
		
		try {
			if(f.exists()) {
				is = new FileInputStream(f);
				if(!copy.exists()) copy.createNewFile();
				os = new FileOutputStream(copy);
				while(true) {
					// is는 파일로부터 읽어들인 데이터를 buf에 저장하게 되고, su에는 buf로부터 읽어들인 개수를 저장한다, 읽어들인 데이터가 없을 경우 -1을 반환한다.
					int su = is.read(buf);
					if(su == -1) break;
					// 읽어들인 개수(su) 만큼만 buf 배열을 읽게된다. 따라서 전체 string의 개수가 buf보다 많을 경우에도 필요한 값만 읽을 수 있게 된다
					os.write(buf, 0, su);
				}
			}	
			if(is != null)is.close();
			if(os != null)os.close();
			System.out.println("복사완료!");
		}catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
