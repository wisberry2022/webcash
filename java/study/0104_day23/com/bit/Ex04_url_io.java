package com.bit;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Ex04_url_io {

	public static void main(String[] args) {
		File f = new File("7zip.exe");
		URL url = null;
		InputStream is = null;
//		InputStreamReader isr = null;
//		BufferedReader br = null;
		BufferedInputStream bis = null;
		OutputStream os = null;
		BufferedOutputStream bos = null;
		
		try {
			url = new URL("https://www.7-zip.org/a/7z2201-x64.exe");
			// 해당 url로 
			URLConnection conn = url.openConnection();
			is = conn.getInputStream();
			bis = new BufferedInputStream(is);
//			isr = new InputStreamReader(is);
//			br = new BufferedReader(isr);
			os = new FileOutputStream(f);
			bos = new BufferedOutputStream(os);
			
			int msg = -1;
			while((msg = bis.read()) != -1) {
				bos.write(msg);
			}
			
			System.out.println("다운로드... 완료!");
			
			if(bos != null) bos.close();
			if(os != null) os.close();
//			if(br != null) br.close();
//			if(isr != null) isr.close();
			if(bis != null) bis.close();
			if(is != null) is.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
