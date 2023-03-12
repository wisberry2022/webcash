package com.api.platform;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.api.util.ApiPlatform;

public class BusanProcess implements ApiPlatform {
	private static Map<String, String> paramMap;
	private static List<String> keySet;
	private static String apiURL = "http://data.humetro.busan.kr/voc/api/open_api_process.tnn?";
	private static String apiKey = "serviceKey=KcPvvyVEaqORzpTkpeX8%2Bk36SeU1KPEAdUK7gVD%2BKt6hYBONhpq0ZQ8NcPEQR6O%2FuYEdi4c030PNJp5TL66XLw%3D%3D";
	private String day;
	private String updown;
	private String stime;
	private String etime;
	private String listnum;
	private String act;
	private String scode;
	
	public BusanProcess() {
		paramMap = new HashMap<>();
		keySet = new ArrayList<>();
		Field[] fields = this.getClass().getDeclaredFields();
		for(Field field:fields) {
			if(field.getModifiers() == 2) {
				String key = field.getName();
				keySet.add(key);
			}			
		}
	}
	
	@Override
	public String getApiURL() {
		return apiURL;
	}

	@Override
	public String getApiKey() {
		return apiKey;
	}
	
	@Override
	public Map<String, String> getParamMap() {
		// TODO Auto-generated method stub
		return paramMap;
	}

	@Override
	public void setParam(String[] params) {
		for(String param:params) {
			String[] kv = param.split(":");
			if(keySet.contains(kv[0])) {
				if(kv[0].equals("listnum")) paramMap.put("enum", kv[1]);
				else paramMap.put(kv[0], kv[1]);
			}
		}
	}
	
	@Override
	public String toString() {
		return "BusanProcess: [day:" + paramMap.get("day")
					+ ", updown:" + paramMap.get("updown")
					+ ", stime:" + paramMap.get("stime")
					+ ", etime:" + paramMap.get("etime")
					+ ", enum:" + paramMap.get("listnum")
					+ ", act:" + paramMap.get("act")
					+ ", scode:" + paramMap.get("scode")
					+ "]";
	}
}
