package com.api.util;

import java.util.Map;

public interface ApiPlatform {
	String getQuery(String[] params);
	String getApiURL();
	String getApiKey();
}
