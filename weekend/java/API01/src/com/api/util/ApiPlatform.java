package com.api.util;

import java.util.Map;

public interface ApiPlatform {
	Map<String, String> getParamMap();
	void setParam(String[] params);
	String getApiURL();
	String getApiKey();
}
