package com.api.util;

import java.net.HttpURLConnection;
import java.util.Map;

public interface ApiCall {

	void setConnectionSetting(String method, String property);
	void setQuery(String[] params) throws Exception;
	void doConnect();
	String getResult();
}
