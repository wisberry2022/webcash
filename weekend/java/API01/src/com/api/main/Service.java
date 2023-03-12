package com.api.main;

import java.util.HashMap;
import java.util.Map;

import com.api.impl.ApiCallImpl;

public class Service {
	
	private static String apiURL = "http://data.humetro.busan.kr/voc/api/open_api_process.tnn?";
	private static String apiKey = "serviceKey=KcPvvyVEaqORzpTkpeX8%2Bk36SeU1KPEAdUK7gVD%2BKt6hYBONhpq0ZQ8NcPEQR6O%2FuYEdi4c030PNJp5TL66XLw%3D%3D";
	
	public static void main(String[] args) {
		
		ApiCallImpl apiCall = new ApiCallImpl(apiURL, apiKey);
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("day", "1");
		paramMap.put("updown", "0");
		paramMap.put("stime", "1153");
		paramMap.put("act", "json");
		paramMap.put("scode", "115");
		apiCall.setParamMap(paramMap);
		try {
			apiCall.setQuery();
			apiCall.setConnectionSetting("GET", "application/json");
			apiCall.doConnect();
			String result = apiCall.getResult();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
