package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Prm01 {

	public static void main(String[] args) {
		URL url = null;
		InputStream is = null;
		
		try {
			url = new URL("http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=159");
			URLConnection conn = url.openConnection();
//			is = conn
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
