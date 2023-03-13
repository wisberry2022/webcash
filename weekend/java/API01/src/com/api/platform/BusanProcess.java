package com.api.platform;

import java.util.List;
import java.util.Map;

import com.api.util.ApiPlatform;
import com.api.util.ApiPlatformImpl;

public class BusanProcess extends ApiPlatformImpl implements ApiPlatform {
	private static String apiURL = "http://data.humetro.busan.kr/voc/api/open_api_process.tnn?";
	private static String apiKey = "serviceKey=KcPvvyVEaqORzpTkpeX8%2Bk36SeU1KPEAdUK7gVD%2BKt6hYBONhpq0ZQ8NcPEQR6O%2FuYEdi4c030PNJp5TL66XLw%3D%3D";
	
	public BusanProcess() {	
		super();
	}
	
	@Override
	public String getApiURL() {
		return apiURL;
	}

	@Override
	public String getApiKey() {
		return apiKey;
	}
}
