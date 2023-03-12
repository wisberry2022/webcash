package com.api.util;

import java.net.HttpURLConnection;
import java.util.Map;

public interface ApiCall {

	void setParamMap(Map<String, String> paramMap);
	void setConnectionSetting(String method, String property);
	void setQuery() throws Exception;
	void doConnect();
	String getResult();
}
