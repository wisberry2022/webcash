package com.api.main;

import com.api.impl.ApiCallImpl;
import com.api.platform.BusanProcess;
import com.api.platform.BusanStationInfo;
import com.api.util.ApiPlatform;

public class Service {
		
	public static void main(String[] args) {
		ApiPlatform bs = new BusanStationInfo();
		ApiPlatform bp = new BusanProcess();
		ApiCallImpl apiCall = new ApiCallImpl(bp);
				
		try {
			apiCall.setQuery(new String[] {"act:json","scode:105"});
			apiCall.setConnectionSetting("GET", "application/json; charset=utf-8");
			apiCall.doConnect();
			String result = apiCall.getResult();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
