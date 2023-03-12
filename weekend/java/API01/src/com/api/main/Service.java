package com.api.main;

import com.api.impl.ApiCallImpl;
import com.api.platform.BusanProcess;

public class Service {
		
	public static void main(String[] args) {
		
		ApiCallImpl apiCall = new ApiCallImpl(new BusanProcess());	

		try {
			apiCall.setQuery(new String[] {"day:2", "updown:1", "stime:1423", "act:json", "scode:115"});
			apiCall.setConnectionSetting("GET", "application/json");
			apiCall.doConnect();
			String result = apiCall.getResult();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
