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

public class ApiCallImpl implements ApiCall {

	private String apiURL;
	private String apiKey;
	private String queryString;
	private Map<String, String> paramMap;
	private String REQUEST_METHOD;
	private String REQUEST_PROPERTY;
	private HttpURLConnection conn;
	
	public ApiCallImpl(String apiURL, String apiKey) {
		this.apiURL = apiURL;
		this.apiKey = apiKey;
	}
	
	@Override
	public void setParamMap(Map<String, String> paramMap) {
		this.paramMap = paramMap;
	}

	@Override
	public void setQuery() throws Exception {
		if(paramMap != null) {
			Set<String> keys = paramMap.keySet();
			Iterator<String> ite = keys.iterator();
			String qS = "&";
			while(ite.hasNext()) {
				String key = ite.next();
				if(ite.hasNext()) qS += key + "=" + paramMap.get(key) + "&";
				else qS += key + "=" + paramMap.get(key);
			}
			this.queryString = qS;			
		}else {
			throw new Exception("paramMap is null, did you executed 'setParamMap' method of this class?");
		}
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	

}
