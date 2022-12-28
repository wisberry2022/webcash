package com.bit;

import java.io.*;

public class Ex05_io_bos_filecopy {

	public static void main(String[] args) {
		File target = new File("high.jpg");
		File copy = new File("copy.jpg");
		InputStream is = null;
		OutputStream os = null;
		
		byte[] buf = new byte[2];
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			if(!copy.exists()) copy.createNewFile(); 
			is = new FileInputStream(target);
			os = new FileOutputStream(copy);
			
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(os);
			
			while(true) {
				int su = bis.read();
				if(su == -1) break;
				bos.write(su);
			}
			
			if(bos != null) bos.close();
			if(bis != null) bis.close();
			if(os != null) os.close();
			if(is != null) is.close();
			System.out.println("copy end!");
		}catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
