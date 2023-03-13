package com.api.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.api.util.ApiCall;
import com.api.util.ApiPlatform;

public class ApiCallImpl implements ApiCall {

	private String apiURL;
	private String apiKey;
	private String queryString;
	private ApiPlatform api;
	private String REQUEST_METHOD;
	private String REQUEST_PROPERTY;
	private HttpURLConnection conn;
	
	public ApiCallImpl(ApiPlatform api) {
		this.apiURL = api.getApiURL();
		this.apiKey = api.getApiKey();
		this.api = api;
	}
	
	@Override
	public void setQuery(String[] params) throws Exception {
		queryString = api.getQuery(params);
	}
	
	@Override
	public void setConnectionSetting(String method, String property) {
		this.REQUEST_METHOD = method;
		this.REQUEST_PROPERTY = property;
	}
	
	@Override
	public void doConnect() {
		try {
			URL url = new URL(apiURL + apiKey + queryString);
			conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod(REQUEST_METHOD);
			conn.setRequestProperty("accept", REQUEST_PROPERTY);
			conn.connect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) conn.disconnect();
		}
	}

	@Override
	public String getResult() {
		try(
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);		
		){
			String result = "";
			String temp = "";
			while((temp = br.readLine()) != null) {
				result += temp;
			}
			
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	

}
