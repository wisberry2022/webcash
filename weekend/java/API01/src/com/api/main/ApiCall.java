package com.api.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ApiCall {
	private static String apiURL = "http://data.humetro.busan.kr/voc/api/open_api_process.tnn?";
	private static String apiKey = "serviceKey=KcPvvyVEaqORzpTkpeX8%2Bk36SeU1KPEAdUK7gVD%2BKt6hYBONhpq0ZQ8NcPEQR6O%2FuYEdi4c030PNJp5TL66XLw%3D%3D";
	private static Map<String, String> paramMap = new HashMap<>();
	
	
	public static void setParamMap(String day, String updown, String stime, String act, String scode) {
		paramMap.put("day", day);
		paramMap.put("updown", updown);
		paramMap.put("stime", stime);
		paramMap.put("act", act);
		paramMap.put("scode", scode);
	}
	
	public static String getQuery(Map<String, String> paramMap) {
		Set<String> keys = paramMap.keySet();
		Iterator<String> ite = keys.iterator();
		String qS = "&";
		while(ite.hasNext()) {
			String key = ite.next();
			if(ite.hasNext()) qS += key + "=" + paramMap.get(key) + "&";
			else qS += key + "=" + paramMap.get(key);
		}
		return qS;
	}
	
	public static void main(String[] args) {
		setParamMap("1", "0", "1301", "json", "110");
		String qS = getQuery(paramMap);
		String serviceURL = apiURL + apiKey + getQuery(paramMap);
		try {
			URL url = new URL(serviceURL);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("accept", "application/json; utf-8");
			conn.connect();
			
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String result = "";
			String temp = "";
			while((temp = br.readLine()) != null) {
				result += temp;
			}
			
			System.out.println(result);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
