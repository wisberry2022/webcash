package com.api.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Test {
	
	private static String apiURL = "http://data.humetro.busan.kr/voc/api/open_api_process.tnn?";
	private static String apiKey = "serviceKey=KcPvvyVEaqORzpTkpeX8%2Bk36SeU1KPEAdUK7gVD%2BKt6hYBONhpq0ZQ8NcPEQR6O%2FuYEdi4c030PNJp5TL66XLw%3D%3D";
	
	public static void main(String[] args) {
		
		HttpURLConnection conn = null;
		InputStream is =null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		
		try {
			URL url = new URL(apiURL+apiKey+"&scode=101&act=json");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("accept", "application/json");
			conn.connect();
			
			is = conn.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			String result = "";
			String temp = "";
			
			while((temp = br.readLine()) != null) {
				result += temp;
			}
			
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(br != null) br.close();
				if(isr != null) isr.close();
				if(is != null) is.close();
				if(conn != null) conn.disconnect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
